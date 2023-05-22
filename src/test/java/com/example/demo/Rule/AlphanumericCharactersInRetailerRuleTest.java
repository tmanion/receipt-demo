package com.example.demo.Rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Item;
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
        Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), LocalTime.parse("09:17:00"), 1.25, items, null);
        int result = rule.processRule(testReceipt);

        assertEquals(6, result);
    }
    
    @Test
    public void nonAlphanumericTest() {
        Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("M&M Corner Market", LocalDate.parse("2023-05-22"), LocalTime.parse("09:17:00"), 1.25, items, null);


        int result = rule.processRule(testReceipt);

        assertEquals(14, result);
    }
}
