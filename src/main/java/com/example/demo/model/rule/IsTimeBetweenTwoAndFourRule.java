package com.example.demo.model.rule;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.example.demo.model.Receipt;

@Component
public class IsTimeBetweenTwoAndFourRule implements Rule {
    public static LocalTime TWO_PM= LocalTime.NOON.plusHours(2);
    public static LocalTime FOUR_PM= LocalTime.NOON.plusHours(4);

    @Override
    public int processRule(Receipt receipt) {
        return receipt.purchaseTime().isAfter(TWO_PM) 
        && receipt.purchaseTime().isBefore(FOUR_PM) ? 10 : 0;
    }
    
}
