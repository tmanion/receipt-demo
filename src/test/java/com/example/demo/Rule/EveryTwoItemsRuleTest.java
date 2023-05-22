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
import com.example.demo.model.rule.EveryTwoItemsRule;

public class EveryTwoItemsRuleTest {

    EveryTwoItemsRule rule;

    @Before
    public void setUp() {
        rule = new EveryTwoItemsRule();
    }

    @Test
    public void simpleSuccess() {
        List<Item> items = new ArrayList();
        for( int i = 0; i < 10; i++) {
            Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
            items.add(item);
        }

        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), LocalTime.parse("09:17:00"), 1.25, items, null);
        int result = rule.processRule(testReceipt);


        assertEquals(25, result);
    }

    @Test
    public void notAMultipleOfTwoTest() {
        List<Item> items = new ArrayList();
        for( int i = 0; i < 7; i++) {
            Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
            items.add(item);
        }

        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), LocalTime.parse("09:17:00"), 1.25, items, null);
        int result = rule.processRule(testReceipt);

        assertEquals(15, result);
    }

    @Test
    public void emptyItemsTest() {
        List<Item> items = new ArrayList();
        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), LocalTime.parse("09:17:00"), 1.25, items, null);
        int result = rule.processRule(testReceipt);

        assertEquals(0, result);
    }
    
}
