package com.grocceryshop.grocceryshop.repository;

import com.grocceryshop.grocceryshop.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {}
