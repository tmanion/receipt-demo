package com.example.demo.Rule;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Item;
import com.example.demo.model.Receipt;
import com.example.demo.model.rule.EveryTwoItemsRule;

public class EveryTwoItemsRuleTest {

    EveryTwoItemsRule rule;

    @Before
    public void setUp() {
        rule = new EveryTwoItemsRule();
    }

    @Test
    public void simpleSuccess() {
        Receipt testReceipt = new Receipt();
        for( int i = 0; i < 10; i++) {
            Item testItem = new Item();
            testReceipt.addItem(testItem);
        }

        int result = rule.processRule(testReceipt);

        assertEquals(25, result);
    }

    @Test
    public void notAMultipleOfTwoTest() {
        Receipt testReceipt = new Receipt();
        for( int i = 0; i < 7; i++) {
            Item testItem = new Item();
            testReceipt.addItem(testItem);
        }

        int result = rule.processRule(testReceipt);

        assertEquals(15, result);
    }

    @Test
    public void emptyItemsTest() {
        Receipt testReceipt = new Receipt();

        int result = rule.processRule(testReceipt);

        assertEquals(0, result);
    }
    
}
