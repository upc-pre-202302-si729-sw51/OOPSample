package com.acme.platform.sales.domain.model.aggregates;

import java.util.UUID;

public class SalesOrderItem {
    private int quantity;
    private Long productId;

    private double unitPrice;

    private UUID itemId;

    private boolean dispatched;

    public SalesOrderItem(int quantity, Long productId, double unitPrice) {
        this.quantity = quantity;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.itemId = UUID.randomUUID();
    }

    public double calculatePrice() {
        return quantity * unitPrice;
    }

    public void dispatch() {
        this.dispatched = true;
    }

    public boolean isDispatched() {
        return dispatched;
    }


}
