package com.assignment.kafkademo.model;

import java.math.BigDecimal;
import java.time.Instant;




public class Transaction {

	
		
	    
	    private String customerId;
	    private BigDecimal amount;
	    private String city;
	    private Instant timestamp;
		
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Instant getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Instant timestamp) {
			this.timestamp = timestamp;
		}
		
		public Transaction() {
			
		}
		
		// Parameterized constructor
	    public Transaction(String customerId, BigDecimal amount, String city, Instant timestamp) {
	        this.customerId = customerId;
	        this.amount = amount;
	        this.city = city;
	        this.timestamp = timestamp;
	    }
		@Override
		public String toString() {
			return "Transaction [customerId=" + customerId + ", amount=" + amount + ", city=" + city + ", timestamp="
					+ timestamp + "]";
		}
	    
	
}
