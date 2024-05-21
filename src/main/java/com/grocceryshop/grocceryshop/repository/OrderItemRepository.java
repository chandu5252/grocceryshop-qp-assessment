package com.grocceryshop.grocceryshop.repository;

import com.grocceryshop.grocceryshop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
