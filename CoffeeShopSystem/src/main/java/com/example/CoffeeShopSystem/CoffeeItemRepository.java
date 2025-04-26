package com.example.CoffeeShopSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoffeeItemRepository extends JpaRepository<CoffeeItem, Integer> {
    Optional<CoffeeItem> findByCoffeeName(String coffeeName);

    // Optional<CoffeeItem> findByPrice(double price);
}
