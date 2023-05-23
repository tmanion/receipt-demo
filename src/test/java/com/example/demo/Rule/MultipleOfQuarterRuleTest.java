package com.example.demo.Rule;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Receipt;
import com.example.demo.model.rule.MultipleOfQarterRule;

public class MultipleOfQuarterRuleTest {
    MultipleOfQarterRule rule;

    @Before
    public void setUp() {
        rule = new MultipleOfQarterRule();
    }

    @Test
    public void simpleSuccess() {
        Receipt testReceipt = new Receipt();
        testReceipt.setTotal(1.25);

        int result = rule.processRule(testReceipt);

        assertEquals(25, result);
    }

    @Test
    public void nonMultipleOfQuarter() {
        Receipt testReceipt = new Receipt();
        testReceipt.setTotal(1.33);

        int result  = rule.processRule(testReceipt);

        assertEquals(0, result);
    }

    @Test
    public void zeroTotal() {
        Receipt testReceipt = new Receipt();
        testReceipt.setTotal(0.0);

        int result  = rule.processRule(testReceipt);

        assertEquals(0, result);
    }
    
}
