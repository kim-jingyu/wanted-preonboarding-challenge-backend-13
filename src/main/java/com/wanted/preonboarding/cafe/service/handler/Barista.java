package com.wanted.preonboarding.cafe.service.handler;

import java.util.UUID;

public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making

    public Barista(int rank, int status){
        this.rank = rank;
        this.status = status;
    }

    private void setRank(int rank){
        this.rank = rank;
    }

    private void setStatus(int status){
        this.status = status;
    }

    public String makeCoffeeTo(UUID orderId, Order order) {
        order.changeOrderStatus(1);

        StringBuilder makeOrders = new StringBuilder();
        makeOrders.append("주문 ID: ")
                .append(orderId.toString())
                .append("\n");
        order.getOrderDetailInfo().forEach(((menu, quantity) -> {
            makeOrders.append(menu)
                    .append("-")
                    .append(quantity + "개 ,");
        }));

        order.changeOrderStatus(2);

        return makeOrders.toString();
    }
}
