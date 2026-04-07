package com.example.orderService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        log.info("heyyyyyy");
        return orderRepository.getAllOrders();
    }

    @GetMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable String id){
        log.info("heyyyyyy");
        return orderRepository.getOrderById(id);
    }
}
