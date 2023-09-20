package com.wanted.preonboarding.cafe.service.handler;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class Cashier {
    private final Cafe cafe;
    private static final OrderBook orderBook = new OrderBook();

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(Map<Menu, Integer> receivedOrders) {
        AtomicLong totalPrice = new AtomicLong(0L);
        receivedOrders.forEach(((menu, quantity) -> {
            totalPrice.addAndGet(menu.getPrice() * quantity);
        }));
        return totalPrice.get();
    }

    public String takeOrder(Map<Menu, Integer> myOrders, long totalPrice) {
        UUID newOrderId = createOrderId();

        Order newOrder = new Order(myOrders, 0);
        orderBook.addOrder(newOrderId, newOrder);

        Barista james = new Barista(0, 0);

        return sendOrder(james, newOrderId, newOrder);
    }

    public String completeOrder(UUID orderId, String message) {
        orderBook.removeOrder(orderId);
        return message;
    }

    @NotNull
    private UUID createOrderId() {
        return UUID.randomUUID();
    }

    private String sendOrder(Barista barista, UUID orderId, Order order) {
        return barista.makeCoffeeTo(orderId, order);
    }
}
