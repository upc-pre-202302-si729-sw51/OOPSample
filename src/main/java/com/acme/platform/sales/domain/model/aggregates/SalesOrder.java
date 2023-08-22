package com.acme.platform.sales.domain.model.aggregates;

import com.acme.platform.shared.domain.model.valueobjects.Address;

import java.util.List;
import java.util.UUID;

public class SalesOrder {
    private SalesOrderStatus status;

    private UUID internalId;

    private Address shippingAddress;

    private List<SalesOrderItem> items;


    public SalesOrder(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        this.status = SalesOrderStatus.CREATED;
        this.internalId = UUID.randomUUID();
    }

    public void addItem(int quantity, Long productId, double unitPrice) {
        this.items.add(new SalesOrderItem(quantity, productId, unitPrice));
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(SalesOrderItem::calculatePrice).sum();
    }

    public void confirm() {
        this.status = SalesOrderStatus.CONFIRMED;
    }

     public void cancel() {
          this.status = SalesOrderStatus.CANCELLED;
          clearItems();
     }

     public void clearItems() {
          this.items.clear();
     }

        public void dispatch() {
            this.status = SalesOrderStatus.SHIPPED;
            items.forEach(SalesOrderItem::dispatch);
        }

}
