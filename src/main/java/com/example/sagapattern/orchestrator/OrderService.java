package com.example.sagapattern.orchestrator;

public class OrderService {
    public static void confirm(String orderId) {
        //Confirmation of the order
        System.out.println("Order " + orderId + " confirmed");
    }
}
