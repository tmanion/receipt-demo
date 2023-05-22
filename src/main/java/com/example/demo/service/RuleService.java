package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Receipt;
import com.example.demo.model.rule.Rule;

@Service
public class RuleService {
    List<Rule> rules;

    public RuleService(List<Rule> rules) {
        this.rules = rules;
    }

    public int runRules(Receipt receipt) {
        int totalPoints = 0;

        totalPoints = rules.stream()
        .mapToInt(rule -> rule.processRule(receipt))
        .sum();

        return totalPoints;
    }   
    
}
