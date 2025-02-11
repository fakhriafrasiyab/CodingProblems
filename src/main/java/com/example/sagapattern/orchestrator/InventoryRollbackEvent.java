package com.example.sagapattern.orchestrator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryRollbackEvent {
    private String orderId;
    private String productId;
    private int quantity;
}
