package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.PointResponse;
import com.example.demo.model.ProcessResponse;
import com.example.demo.model.Receipt;
import com.example.demo.repositories.ReceiptRepository;
import com.example.demo.service.RuleService;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    @Autowired
    private RuleService ruleService;

    @Autowired
    ReceiptRepository receiptRepository;

    @PostMapping("/process")
    @ResponseStatus(HttpStatus.OK)
    public ProcessResponse processReceipt(@RequestBody final Receipt receipt) {
        int totalPoints = ruleService.runRules(receipt);
        
        receipt.setPoints(totalPoints);

        try {
            Receipt result = receiptRepository.save(receipt);
            ProcessResponse processResponse = new ProcessResponse(result.getId());
        return processResponse;
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "The receipt is invalid");
        }
    }
    
    @GetMapping("/{id}/points")
    @ResponseStatus(HttpStatus.OK)
    public PointResponse getPointsForId(@PathVariable Long id) {
        Optional<Receipt> receiptOptional = receiptRepository.findById(id);

        if (!receiptOptional.isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No receipt found for that id");
        }

        Receipt receipt = receiptOptional.get();
        PointResponse response = new PointResponse(receipt.getPoints());
        return response;
    }

    public void setRuleService(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    public void setReceiptRepository(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    protected ResponseEntity handleInvalidException(RuntimeException ex, WebRequest request) {
        String body = "{\"description\": \"The receipt is invalid\"}";
        return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ResponseStatusException.class})
    protected ResponseEntity handleResponseException(RuntimeException ex, WebRequest request) {
        String body = "{\"description\": \"No receipt found for that id\"}";
        return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
    }
}
