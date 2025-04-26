package com.example.CoffeeShopSystem;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coffeedetails")
public class CoffeeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coffeeId;

    @Column(name = "coffee_name", nullable = false)
    private String coffeeName;

    @Column(name = "coffee_price", nullable = false)
    private double price;

    public CoffeeItem() {
    }

    public CoffeeItem(Integer coffeeId, String coffeeName, double price) {
        this.coffeeId = coffeeId;
        this.coffeeName = coffeeName;
        this.price = price;
    }

    public Integer getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Integer coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CoffeeItem [coffeeId=" + coffeeId + ", coffeeName=" + coffeeName + ", price=" + price + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeId, coffeeName, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        CoffeeItem other = (CoffeeItem) obj;
        return Objects.equals(coffeeId, other.coffeeId)
            && Objects.equals(coffeeName, other.coffeeName)
            && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
    }
}
