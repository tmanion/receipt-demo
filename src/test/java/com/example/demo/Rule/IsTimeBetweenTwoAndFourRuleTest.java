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
        Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), testTime, 1.25, items, null);
        int result = rule.processRule(testReceipt);

        assertEquals(10, result);
    }

    @Test
    public void timeIsOutOfRange() {
        LocalTime testTime = LocalTime.MIDNIGHT.plusHours(3).plusMinutes(2);
        Item item = new Item("Pepsi - 12.oz", (float) 1.25, null);
        List<Item> items = new ArrayList<>();
        items.add(item);
        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2023-05-22"), testTime, 1.25, items, null);
        int result = rule.processRule(testReceipt);;

        assertEquals(0, result);
    }
    
}
