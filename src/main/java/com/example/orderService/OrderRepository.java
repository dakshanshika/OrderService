package com.example.orderService;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRepository {

    private final List<Order> orders = List.of(
            new Order("1", "Laptop", 75000),
            new Order("2", "Mobile Phone", 30000),
            new Order("3", "Headphones", 2500),
            new Order("4", "Keyboard", 1500),
            new Order("5", "Mouse", 800),
            new Order("6", "Monitor", 12000),
            new Order("7", "Tablet", 22000),
            new Order("8", "Printer", 9500),
            new Order("9", "Webcam", 2000),
            new Order("10", "External HDD", 6000)
    );

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(String id) {
        List<Order> order1 = orders.stream()
                .filter(order -> order.id().equals(id))
                .toList();

        return order1.getFirst();
    }

}
