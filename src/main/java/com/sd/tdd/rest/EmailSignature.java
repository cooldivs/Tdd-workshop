package com.sd.tdd.rest;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailSignature {

    private final String signature;
    private final String department;

    @JsonCreator
    public EmailSignature(@JsonProperty("signature")String signature, @JsonProperty("department") String department) {
        this.signature = signature;
        this.department = department;
    }

    public String getSignature() {
        return signature;
    }

    public String getDepartment() {
        return department;
    }
}
