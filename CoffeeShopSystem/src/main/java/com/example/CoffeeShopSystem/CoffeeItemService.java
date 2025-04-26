package com.example.CoffeeShopSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeItemService {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeItemService.class);

    @Autowired
    private CoffeeItemRepository repository;

    // Create CoffeeItem
    public CoffeeItem saveCoffeeItem(CoffeeItem coffeeItem) {
        logger.debug("Attempting to save coffee item with name: {}", coffeeItem.getCoffeeName());
        CoffeeItem savedCoffeeItem = repository.save(coffeeItem);
        logger.debug("Successfully saved coffee item with ID: {}", savedCoffeeItem.getCoffeeId());
        return savedCoffeeItem;
    }

    // Get All CoffeeItems
    public List<CoffeeItem> getAllCoffeeItems() {
        logger.debug("Retrieving all coffee items");
        List<CoffeeItem> coffeeItems = repository.findAll();
        logger.debug("Found {} coffee items", coffeeItems.size());
        return coffeeItems;
    }

    // Get CoffeeItem by ID
    public Optional<CoffeeItem> getCoffeeItemById(Integer id) {
        logger.debug("Retrieving coffee item with ID: {}", id);
        Optional<CoffeeItem> coffeeItem = repository.findById(id);
        if (coffeeItem.isPresent()) {
            logger.debug("Found coffee item with ID: {}", id);
        } else {
            logger.debug("No coffee item found with ID: {}", id);
        }
        return coffeeItem;
    }

    // Get CoffeeItem by Name
    public Optional<CoffeeItem> getCoffeeItemByCoffeeName(String coffeeName) {
        logger.debug("Retrieving coffee item with name: {}", coffeeName);
        Optional<CoffeeItem> coffeeItem = repository.findByCoffeeName(coffeeName);
        if (coffeeItem.isPresent()) {
            logger.debug("Found coffee item with name: {}", coffeeName);
        } else {
            logger.debug("No coffee item found with name: {}", coffeeName);
        }
        return coffeeItem;
    }

    // Update CoffeeItem
    public CoffeeItem updateCoffeeItem(Integer id, CoffeeItem updatedCoffeeItem) {
        logger.debug("Attempting to update coffee item with ID: {}", id);
        return repository.findById(id)
                .map(coffeeItem -> {
                    logger.debug("Found coffee item with ID: {}, updating details", id);
                    coffeeItem.setCoffeeName(updatedCoffeeItem.getCoffeeName());
                    coffeeItem.setPrice(updatedCoffeeItem.getPrice());
                    
                    CoffeeItem savedCoffeeItem = repository.save(coffeeItem);
                    logger.debug("Successfully updated coffee item with ID: {}", id);
                    return savedCoffeeItem;
                })
                .orElseThrow(() -> {
                    logger.debug("Failed to update - coffee item not found with ID: {}", id);
                    return new RuntimeException("Coffee item not found with ID: " + id);
                });
    }

    // Delete CoffeeItem
    public void deleteCoffeeItem(Integer id) {
        logger.debug("Attempting to delete coffee item with ID: {}", id);
        repository.deleteById(id);
        logger.debug("Successfully deleted coffee item with ID: {}", id);
    }
}
