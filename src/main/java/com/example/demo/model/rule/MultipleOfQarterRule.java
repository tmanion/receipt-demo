package com.example.demo.model.rule;

import org.springframework.stereotype.Component;

import com.example.demo.model.Receipt;

@Component
public class MultipleOfQarterRule implements Rule {

    @Override
    public int processRule(Receipt receipt) {
        return receipt.getTotal() > 0.0 &&
            receipt.getTotal() % 0.25 == 0 ? 25 : 0;
    }
    
}
