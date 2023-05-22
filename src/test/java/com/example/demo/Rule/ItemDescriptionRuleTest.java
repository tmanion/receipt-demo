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
import com.example.demo.model.rule.ItemDescriptionRule;

public class ItemDescriptionRuleTest {
    ItemDescriptionRule rule;

    @Before
    public void setUp() {
        rule = new ItemDescriptionRule();
    }

    @Test
    public void simpleSuccess() {
        Item item = new Item("Emils Cheese Pizza", (float) 12.25, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), LocalTime.parse("09:33:00"), 12.25, items, null);
        int result = rule.processRule(testReceipt);

        assertEquals(3, result);
    }

    @Test
    public void leadingAndTrailingSpacesTest() {
        Item item = new Item("   Klarbrunn 12-PK 12 FL OZ  ", (float) 12.00, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), LocalTime.parse("09:33:00"), 12.25, items, null);
        int result = rule.processRule(testReceipt);

        assertEquals(3, result);
    }
}
