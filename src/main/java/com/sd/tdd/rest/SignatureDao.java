package com.sd.tdd.rest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SignatureDao {
    public List<EmailSignature> getAll() {
        ArrayList<EmailSignature> signs = new ArrayList<>();
        signs.add( new EmailSignature("divyap","IT"));;
        return signs;
    }

    public EmailSignature getSignature(String department) {
        return new EmailSignature("divyap","IT");
    }

    public void save(EmailSignature signature) {

    }
}
