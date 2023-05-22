package com.example.demo.Rule;

import static org.junit.Assert.assertEquals;

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
        Item testItem = new Item();
        testItem.setShortDescription("Emils Cheese Pizza");
        testItem.setPrice(12.25f);

        Receipt testReceipt = new Receipt();
        testReceipt.addItem(testItem);


        int result = rule.processRule(testReceipt);

        assertEquals(3, result);
    }

    @Test
    public void leadingAndTrailingSpacesTest() {
        Item testItem = new Item();
        testItem.setShortDescription("   Klarbrunn 12-PK 12 FL OZ  ");
        testItem.setPrice(12.00f);

        Receipt testReceipt = new Receipt();
        testReceipt.addItem(testItem);


        int result = rule.processRule(testReceipt);

        assertEquals(3, result);
    }
}
