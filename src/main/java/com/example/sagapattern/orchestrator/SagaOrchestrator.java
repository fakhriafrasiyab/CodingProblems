package com.example.sagapattern.orchestrator;

public class SagaOrchestrator {
    public void processOrder(String productId, String orderId, int quantity, double amount) {
        try {
            //Step 1
            InventoryService.reserve(productId, quantity);
            System.out.println("Inventory reserved");

            //Step 2
            PaymentService.process(orderId, amount);
            System.out.println("Payment is done");

            //Step 3
            OrderService.confirm(orderId);
        } catch (Exception e) {
            System.out.println("System Error occurred " + e.getMessage());
            InventoryService.rollback(productId, quantity);
            System.out.println("Rolled back inventory");
        }
    }
}
