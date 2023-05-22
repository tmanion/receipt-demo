package com.example.demo.Rule;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Receipt;
import com.example.demo.model.rule.IsDateOddRule;

public class IsDateOddRuleTest {
    IsDateOddRule rule;

    @Before
    public void setUp() {
        rule = new IsDateOddRule();
    }

    @Test
    public void dateIsOdd() {
        LocalDate testDate = LocalDate.parse("2022-01-01");
        Receipt testReceipt = new Receipt();
        testReceipt.setPurchaseDate(testDate);

        int result = rule.processRule(testReceipt);

        assertEquals(6, result);
    }

    @Test
    public void dateIsEven() {
        LocalDate testDate = LocalDate.parse("2022-01-02");
        Receipt testReceipt = new Receipt();
        testReceipt.setPurchaseDate(testDate);

        int result = rule.processRule(testReceipt);

        assertEquals(0, result);
    }
    
}
