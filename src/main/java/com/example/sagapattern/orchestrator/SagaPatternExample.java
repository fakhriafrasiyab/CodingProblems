package com.example.sagapattern.orchestrator;

public class SagaPatternExample {
    public static void main(String[] args) {
        SagaOrchestrator orchestrator = new SagaOrchestrator();
        orchestrator.processOrder("ORD123", "PROD001", 100, 500);
    }
}
