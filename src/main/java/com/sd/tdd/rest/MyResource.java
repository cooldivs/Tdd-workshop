package com.sd.tdd.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/mytest")
public class MyResource {

    @RequestMapping(path="/{testName}", method = POST)
    public ResponseEntity<String> performTest(@PathVariable String testName) throws Exception {
        return ResponseEntity.ok("OK");
    }
}
