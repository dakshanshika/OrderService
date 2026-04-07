package com.example.orderService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrderCont {

//    Logger logger = LoggerFactory.getLogger(OrderCont.class);
    @Autowired
    private OrderRepository orderRepository;

    public OrderCont(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/getOrders")
    public List<Order> getAllOrders(){
//        logger.info("welcome !! Order service");
        log.info("Invocking getAllOrders-------------");
        return orderRepository.getAllOrders();
    }

    @GetMapping("/getOrderById/{id}")
    @Cacheable(value = "orders", key = "#id")
    public Order getOrderById(@PathVariable String id){
        log.info("Invoking getOrderById----------- ");
        return orderRepository.getOrderById(id);
    }

    @PutMapping ("/updateOrder/{orderId}")
    @CachePut(value = "orders", key = "#orderId")
    public Order updateOrderById(@PathVariable String orderId, @RequestBody Order order){
        log.info("Invoking getOrderById----------- ");
        return orderRepository.updateOrder(orderId,order);
    }

    @DeleteMapping ("/deleteOrder/{orderId}")
    @CacheEvict(value = "orders", key = "#orderId")
    public Order deleteOrderById(@PathVariable String orderId){
        log.info("Invoking deleteOrder----------- ");
        return orderRepository.deleteOrderById(orderId);
    }
}
