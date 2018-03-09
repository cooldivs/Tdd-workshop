package com.sd.tdd.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(MyResource.class)
public class MyResourceTest {


    @Test
    public void shouldProcessTheRequestAndReturnSuccess() {
        // Given


        // When
    }
}