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
import com.example.demo.model.rule.MultipleOfQarterRule;

public class MultipleOfQuarterRuleTest {
    MultipleOfQarterRule rule;

    @Before
    public void setUp() {
        rule = new MultipleOfQarterRule();
    }

    @Test
    public void simpleSuccess() {
        Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), LocalTime.parse("09:17:00"), 1.25, items, null);
        int result = rule.processRule(testReceipt);;

        assertEquals(25, result);
    }

    @Test
    public void nonMultipleOfQuarter() {
        Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), LocalTime.parse("09:17:00"), 1.33, items, null);
        int result = rule.processRule(testReceipt);

        assertEquals(0, result);
    }
    
}
