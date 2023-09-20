package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final Map<Menu, Integer> myOrders;

    public Customer(String paymentMethod, Map<Menu, Integer> myOrders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = myOrders;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
