package com.example.orderService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class OrderRepository {

    private final List<Order> ordersMy = Arrays.asList(
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

    private List<Order> orders = new ArrayList<>(ordersMy);

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(String id) {
        List<Order> order1 = orders.stream()
                .filter(order -> order.getId().equals(id))
                .toList();
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return order1.getFirst();
    }

    public Order updateOrder(String orderId, Order order) {

        Order orderById = getOrderById(orderId);
        if (orderById != null){
            orderById.setOrderPrice(order.getOrderPrice());
            orderById.setItem(order.getItem());
        }
        return orderById;
    }

    public Order deleteOrderById(String orderId) {
        Order exitingOrder = getOrderById(orderId);
        if (exitingOrder != null){
            orders.remove(exitingOrder);
        }else{
            throw new RuntimeException("Order Id does not exist");
        }

        return exitingOrder;
    }
}
