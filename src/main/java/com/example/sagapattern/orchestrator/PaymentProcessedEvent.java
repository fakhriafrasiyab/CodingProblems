package com.example.sagapattern.orchestrator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentProcessedEvent {
    private String orderId;
    private double amount;
}
