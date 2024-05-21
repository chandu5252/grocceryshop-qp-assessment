package com.grocceryshop.grocceryshop.repository;

import com.grocceryshop.grocceryshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
