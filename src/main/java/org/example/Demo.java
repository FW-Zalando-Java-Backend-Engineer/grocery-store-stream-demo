package org.example;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates all stream operations on sample inventory.
 *
 */
public class Demo {
    public static void main( String[] args ) {
        List<Product> inventory = Arrays.asList(
                new Product("Milk", "Dairy", 1.5, 50, true),
                new Product("Cheese", "Dairy", 4.0, 20, true),
                new Product("Apple", "Fruit", 0.5, 200, true),
                new Product("Bread", "Bakery", 2.0, 100, true),
                new Product("Soap", "Non-Food", 3.0, 80, false),
                new Product("Toothpaste", "Non-Food", 2.5, 150, false)
        );

        InventoryService service = new InventoryService();

        System.out.println("\nLow Stock (< 60):");
        service.filterLowStock(inventory, 60).forEach(System.out::println);

        System.out.println("\nProduct Names (Uppercase, Sorted):");
        service.getProductNamesUpper(inventory).forEach(System.out::println);

        System.out.println("\nGrouped by Category:");
        service.groupByCategory(inventory).forEach((k, v) -> {
            System.out.println(k + " => " + v);
        });

        System.out.println("\nPartitioned by Perishability:");
        service.partitionByPerishable(inventory).forEach((k, v) -> {
            System.out.println((k ? "Perishable" : "Non-Perishable") +  " => "  + v);
        });

        System.out.println("\nTotal Inventory Value:");
        System.out.println("$" + service.calculateTotalValue(inventory));

        System.out.println("\nMost Expensive Product:");
        service.findMostExpensive(inventory).ifPresent(System.out::println);

    }
}
