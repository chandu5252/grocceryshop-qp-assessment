package com.grocceryshop.grocceryshop.service;

import com.grocceryshop.grocceryshop.entity.GroceryItem;
import com.grocceryshop.grocceryshop.entity.Order;
import com.grocceryshop.grocceryshop.entity.OrderItem;
import com.grocceryshop.grocceryshop.exception.InsufficientStockException;
import com.grocceryshop.grocceryshop.exception.ResourceNotFoundException;
import com.grocceryshop.grocceryshop.repository.GroceryItemRepository;
import com.grocceryshop.grocceryshop.repository.OrderItemRepository;
import com.grocceryshop.grocceryshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public Order createOrder(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            GroceryItem item = groceryItemRepository.findById(orderItem.getGroceryItem().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
            if (item.getQuantity() < orderItem.getQuantity()) {
                throw new InsufficientStockException("Not enough stock for item: " + item.getName());
            }
            item.setQuantity(item.getQuantity() - orderItem.getQuantity());
            groceryItemRepository.save(item);
        }
        return orderRepository.save(order);
    }

    public Order getOrdersByUser(Long userId) {
        return orderRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("Invalid id : "+userId));
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
}
