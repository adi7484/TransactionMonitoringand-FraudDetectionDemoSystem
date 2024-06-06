package com.assignment.kafkademo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.assignment.kafkademo.model.Transaction;

@Service
public class KafkaProducerService
{
	@Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @Autowired
    private FraudTransactionPublisherService fraudTransactionPublisherService;

    private final static String TOPIC_NAME = "TransactionTopic";

    public void sendMessage(Transaction transaction) {
        if (fraudDetectionService.isFraudulent(transaction)) {
            fraudTransactionPublisherService.publish(transaction);
            System.out.println("Suspicious transaction detected and published for customerId: " + transaction.getCustomerId());
        } else {
            kafkaTemplate.send(TOPIC_NAME, transaction);
        }
    }
}
