package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Order{
    private final Map<Menu, Integer> orderGroup;
    private int status; // 0: pending, 1: processing, 2: completed

    public Order(Map<Menu, Integer> orderGroup, int status) {
        this.orderGroup = orderGroup;
        this.status = status;
    }

    public void changeOrderStatus(int newStatus) {
        this.status = newStatus;
    }

    public Map<Menu, Integer> getOrderDetailInfo() {
        return this.orderGroup;
    }
}
