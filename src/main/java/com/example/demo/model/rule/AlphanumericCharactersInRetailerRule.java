package com.example.demo.model.rule;

import org.springframework.stereotype.Component;

import com.example.demo.model.Receipt;

@Component
public class AlphanumericCharactersInRetailerRule implements Rule {

    public static final String REPLACEMENT_PATTE_STRING = "[^A-Za-z0-9]";
    @Override
    public int processRule(Receipt receipt) {
        String retailerName = receipt.getRetailer();

        String normalized = retailerName.replaceAll(REPLACEMENT_PATTE_STRING, "");

        return normalized.length();
    }

    
}
