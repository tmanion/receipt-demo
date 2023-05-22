package com.example.demo.Rule;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Receipt;
import com.example.demo.model.rule.IsTimeBetweenTwoAndFourRule;

public class IsTimeBetweenTwoAndFourRuleTest {
    IsTimeBetweenTwoAndFourRule rule;

    @Before
    public void setUp() {
        rule = new IsTimeBetweenTwoAndFourRule();
    }

    @Test
    public void timeIsInbetween2And4() {
        LocalTime testTime = LocalTime.NOON.plusHours(3).plusMinutes(24);
        Receipt testReceipt = new Receipt();
        testReceipt.setPurchaseTime(testTime);

        int result = rule.processRule(testReceipt);

        assertEquals(10, result);
    }

    @Test
    public void timeIsOutOfRange() {
        LocalTime testTime = LocalTime.MIDNIGHT.plusHours(3).plusMinutes(2);
        Receipt testReceipt = new Receipt();
        testReceipt.setPurchaseTime(testTime);

        int result = rule.processRule(testReceipt);

        assertEquals(0, result);
    }
    
}
