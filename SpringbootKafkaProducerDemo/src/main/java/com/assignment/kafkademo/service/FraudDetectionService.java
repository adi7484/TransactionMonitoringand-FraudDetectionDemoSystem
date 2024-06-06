package com.assignment.kafkademo.service;

import com.assignment.kafkademo.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FraudDetectionService {
	 private Map<String, List<Transaction>> customerTransactions = new ConcurrentHashMap<>();
	    private Map<String, Set<String>> customerCities = new ConcurrentHashMap<>();

	   

	    // Rule 2: More than 2 different cities with the same customerId
	    private boolean isSuspiciousCityChange(String customerId, Transaction transaction) {
	        Set<String> cities = customerCities.getOrDefault(customerId, new HashSet<>());

	        cities.add(transaction.getCity());

	        if (cities.size() > 2) {
	            return true;
	        }

	        customerCities.put(customerId, cities);
	        return false;
	    }

	    public boolean isFraudulent(Transaction transaction) {
	        String customerId = transaction.getCustomerId();
	        return  isSuspiciousCityChange(customerId, transaction);
	    }
}
