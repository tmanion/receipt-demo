package com.example.demo.Rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Receipt;
import com.example.demo.model.rule.AlphanumericCharactersInRetailerRule;

public class AlphanumericCharactersInRetailerRuleTest {

    AlphanumericCharactersInRetailerRule rule;

    @Before
    public void setUp() {
        rule = new AlphanumericCharactersInRetailerRule();
    }

    @Test
    public void simpleSuccess() {
        Receipt testReceipt = new Receipt();
        testReceipt.setRetailer("Target");

        int result = rule.processRule(testReceipt);

        assertEquals(6, result);
    }
    
    @Test
    public void nonAlphanumericTest() {
        Receipt testReceipt = new Receipt();
        testReceipt.setRetailer("M&M Corner Market");

        int result = rule.processRule(testReceipt);

        assertEquals(14, result);
    }
}
