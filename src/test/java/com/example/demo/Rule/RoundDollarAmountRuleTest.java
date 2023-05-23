package com.example.demo.Rule;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Receipt;
import com.example.demo.model.rule.RoundDollarAmountRule;

public class RoundDollarAmountRuleTest {
    private RoundDollarAmountRule rule;

    @Before
    public void setUp() {
        rule = new RoundDollarAmountRule();
    }

    @Test
    public void simpleSuccess() {
        Receipt testReceipt = new Receipt();
        testReceipt.setTotal(42.00d);

        int result = rule.processRule(testReceipt);

        assertEquals(50, result);
    }

    @Test
    public void notARoundNumberTest() {
        Receipt testReceipt = new Receipt();
        testReceipt.setTotal(42.42d);

        int result = rule.processRule(testReceipt);

        assertEquals(0, result);
    }

    @Test
    public void zeroTest() {
        Receipt testReceipt = new Receipt();
        testReceipt.setTotal(0.0d);

        int result = rule.processRule(testReceipt);

        assertEquals(0, result);
    }
}
