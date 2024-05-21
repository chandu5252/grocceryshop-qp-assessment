package com.grocceryshop.grocceryshop.controller;

import com.grocceryshop.grocceryshop.entity.Order;
import com.grocceryshop.grocceryshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public List<Order> getOrders(){
        return service.getOrders();
    }

}
