package com.example.CoffeeShopSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffeeitems")
@CrossOrigin(origins = "http://localhost:56220/") // or whatever frontend port you are using
public class CoffeeItemController {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeItemController.class);

    @Autowired
    private CoffeeItemService service;

    // Register CoffeeItem
    @PostMapping("/register")
    public ResponseEntity<CoffeeItem> registerCoffeeItem(@RequestBody CoffeeItem coffeeItem) {
        logger.debug("Received request to register coffee item with name {}", coffeeItem.getCoffeeName());
        CoffeeItem savedCoffeeItem = service.saveCoffeeItem(coffeeItem);
        logger.debug("Successfully registered coffee item with ID: {}", savedCoffeeItem.getCoffeeId());
        return ResponseEntity.ok(savedCoffeeItem);
    }

    // Get All CoffeeItems
    @GetMapping("/all")
    public ResponseEntity<List<CoffeeItem>> getAllCoffeeItems() {
        logger.debug("Received request to get all coffee items");
        List<CoffeeItem> coffeeItems = service.getAllCoffeeItems();
        logger.debug("Returning {} coffee items", coffeeItems.size());
        return ResponseEntity.ok(coffeeItems);
    }

    // Get CoffeeItem by ID
    @GetMapping("/{id}")
    public ResponseEntity<CoffeeItem> getCoffeeItemById(@PathVariable Integer id) {
        logger.debug("Received request to get coffee item with ID: {}", id);
        Optional<CoffeeItem> coffeeItem = service.getCoffeeItemById(id);
        if (coffeeItem.isPresent()) {
            logger.debug("Returning coffee item with ID: {}", id);
            return ResponseEntity.ok(coffeeItem.get());
        } else {
            logger.debug("Coffee item with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Get CoffeeItem by Name
    @GetMapping("/coffee-name/{coffeeName}")
    public ResponseEntity<CoffeeItem> getCoffeeItemByCoffeeName(@PathVariable String coffeeName) {
        logger.debug("Received request to get coffee item with name: {}", coffeeName);
        Optional<CoffeeItem> coffeeItem = service.getCoffeeItemByCoffeeName(coffeeName);
        if (coffeeItem.isPresent()) {
            logger.debug("Returning coffee item with name: {}", coffeeName);
            return ResponseEntity.ok(coffeeItem.get());
        } else {
            logger.debug("Coffee item with name: {} not found", coffeeName);
            return ResponseEntity.notFound().build();
        }
    }

    // Update CoffeeItem
    @PutMapping("/update/{id}")
    public ResponseEntity<CoffeeItem> updateCoffeeItem(@PathVariable Integer id, @RequestBody CoffeeItem coffeeItem) {
        logger.debug("Received request to update coffee item with ID: {}", id);
        CoffeeItem updatedCoffeeItem = service.updateCoffeeItem(id, coffeeItem);
        logger.debug("Successfully updated coffee item with ID: {}", id);
        return ResponseEntity.ok(updatedCoffeeItem);
    }

    // Delete CoffeeItem
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCoffeeItem(@PathVariable Integer id) {
        logger.debug("Received request to delete coffee item with ID: {}", id);
        service.deleteCoffeeItem(id);
        logger.debug("Successfully deleted coffee item with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
