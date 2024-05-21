package com.grocceryshop.grocceryshop.service;

import com.grocceryshop.grocceryshop.entity.GroceryItem;
import com.grocceryshop.grocceryshop.exception.ResourceNotFoundException;
import com.grocceryshop.grocceryshop.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepository repository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        return repository.save(item);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return repository.findAll();
    }

    public void deleteGroceryItem(Long id) {
        repository.deleteById(id);
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem item) {
        item.setId(id);
        return repository.save(item);
    }

    public GroceryItem updateInventory(Long id, int quantity) {
        GroceryItem item = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        item.setQuantity(quantity);
        return repository.save(item);
    }
}


