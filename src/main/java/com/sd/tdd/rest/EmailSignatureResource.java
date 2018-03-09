package com.sd.tdd.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/signatures")
public class EmailSignatureResource {
    @Autowired
    private SignatureDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EmailSignature>> getSignature() {

        return ResponseEntity.ok(dao.getAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{department}")
    public ResponseEntity<EmailSignature> getSignature(@PathVariable String department){
        return ResponseEntity.ok(dao.getSignature(department));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> insertSignature(@RequestBody EmailSignature signature){
        dao.save(signature);
        return ResponseEntity.ok("OK");
    }
}
