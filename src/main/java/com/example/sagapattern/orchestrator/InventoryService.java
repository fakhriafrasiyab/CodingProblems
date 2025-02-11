package com.example.sagapattern.orchestrator;

public class InventoryService {
    public static void reserve(String productId, int quantity) {
        //Simulation reserve logic
        if (quantity > 10) {
            throw new RuntimeException("Insufficient inventory.");
        }
    }

    public static void rollback(String productId, int quantity) {
        //Undo reservation
        System.out.println("Inventory rollback completed for product " + productId);
    }
}
