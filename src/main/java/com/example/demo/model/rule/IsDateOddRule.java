package com.example.demo.model.rule;

import org.springframework.stereotype.Component;

import com.example.demo.model.Receipt;

@Component
public class IsDateOddRule implements Rule{

    @Override
    public int processRule(Receipt receipt) {
        if (receipt.purchaseDate().getDayOfMonth() % 2 != 0) {
            return 6;
        }

        return 0;
    }
    
}
