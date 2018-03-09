package com.sd.tdd.rest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(EmailSignatureResource.class)
public class EmailSignatureResourceTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    SignatureDao signatureDao;

    @Test
    public void shouldReturnSuccesfullResponseWithEmailSignature() throws Exception {
        //Given
        when(signatureDao.getAll()).thenReturn(Arrays.asList(new EmailSignature("testSignature","testDepartment"),
                new EmailSignature("testSignature1","testDepartment1")));
        //When
        mockMvc.perform(get("/signatures")
                .contentType(MediaType.ALL)
                .content(""))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[{\"department\" : \"testDepartment\", \"signature\" : \"testSignature\"}," +
                        "{\"department\" : \"testDepartment1\", \"signature\" : \"testSignature1\"}]"));
    }


    @Test
    public void shouldReturnSingleSignatureForSingleDepartment() throws Exception {
        when(signatureDao.getSignature("testDepartment")).thenReturn(new EmailSignature("testSignature","testDepartment"));
        //When
        mockMvc.perform(get("/signatures/testDepartment")
                .contentType(MediaType.ALL)
                .content(""))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("{\"department\" : \"testDepartment\", \"signature\" : \"testSignature\"}"));
    }

    @Test
    public void shouldInsertSingleSignature() throws Exception {
        mockMvc.perform(post("/signatures")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"department\" : \"testDepartment\", \"signature\" : \"testSignature\"}"))
                .andExpect(status().is2xxSuccessful());

        verify(signatureDao, times(1)).save(any());
    }
}