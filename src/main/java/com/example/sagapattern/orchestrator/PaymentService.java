package com.example.sagapattern.orchestrator;

public class PaymentService {
    public static void process(String orderId, double amount) {
        //Simulate payment logic
        if (amount > 1000) {
            throw new RuntimeException("Payment Declined!!");
        }
    }
}
