package com.grocceryshop.grocceryshop.controller;


import com.grocceryshop.grocceryshop.entity.GroceryItem;
import com.grocceryshop.grocceryshop.entity.Order;
import com.grocceryshop.grocceryshop.service.GroceryItemService;
import com.grocceryshop.grocceryshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private GroceryItemService groceryItemService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/grocery-items")
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/orders")
    public Order getOrdersByUser(@RequestParam Long userId) {
        return orderService.getOrdersByUser(userId);
    }
}
