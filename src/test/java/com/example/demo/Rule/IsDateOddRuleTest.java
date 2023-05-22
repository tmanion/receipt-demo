package com.example.demo.Rule;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Item;
import com.example.demo.model.Receipt;
import com.example.demo.model.ReceiptObj;
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
        Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("Target", testDate, LocalTime.parse("09:17:00"), 1.25, items, null);
        int result = rule.processRule(testReceipt);

        assertEquals(6, result);
    }

    @Test
    public void dateIsEven() {
        LocalDate testDate = LocalDate.parse("2022-01-02");
        Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("Target", testDate, LocalTime.parse("09:17:00"), 1.25, items, null);
        int result = rule.processRule(testReceipt);

        assertEquals(0, result);
    }
    
}
