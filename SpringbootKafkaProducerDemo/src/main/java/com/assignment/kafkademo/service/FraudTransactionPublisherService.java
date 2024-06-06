package com.assignment.kafkademo.service;


import com.assignment.kafkademo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FraudTransactionPublisherService {

    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    private final static String FRAUD_TOPIC_NAME = "FraudTransactionTopic";

    public void publish(Transaction transaction) {
        kafkaTemplate.send(FRAUD_TOPIC_NAME, transaction);
    }
}

