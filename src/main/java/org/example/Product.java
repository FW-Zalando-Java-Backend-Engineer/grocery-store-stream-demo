package org.example;

import java.util.Objects;

/**
 * Represents a product in the grocery store.
 * POJO
 * */
public class Product {
    // Fields
    private String name;
    private String category;
    private double price;
    private int quantity;
    private boolean perishable;

    // Constructor
    public Product(String name,
                   String category,
                   double price,
                   int quantity,
                   boolean perishable) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.perishable = perishable;
    }

  // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isPerishable() {
        return perishable;
    }

    @Override
    public String toString() {
        return name + ": $" + price + " (Qty: " + quantity + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Reference equality
        if (o == null || getClass() != o.getClass()) return false; // ensure exact class match
        Product product = (Product) o; //  you know o is a Product, Safe cast o to Product

        /**
         * Two Products are equal if their name fields are equal.
         * Objects.equals(...) safely handles null, so you don’t need to manually check for nulls.
        * */
        return Objects.equals(name, product.name);
    }
}
