package com.assignment.kafkademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.kafkademo.model.Transaction;
import com.assignment.kafkademo.service.KafkaProducerService;

@RestController
public class KafkaMessageController
{
   
    @Autowired
	private KafkaProducerService kafkaProducerService;
 
    @PostMapping("/publish")
    public String publishMessage(@RequestBody Transaction transaction)
    {
    	kafkaProducerService.sendMessage(transaction);
		System.out.println("Successfully Published the Transaction = '" + transaction + "' to the TransactionTopic");
		return "Successfully Published the Transaction = '" + transaction + "' to the TransactionTopic";
    }
    
    @PostMapping("/fraudtest")
    public void publishTransactions(@RequestBody List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            kafkaProducerService.sendMessage(transaction);
        }
    }
}
