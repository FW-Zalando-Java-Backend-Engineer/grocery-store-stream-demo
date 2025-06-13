package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Contains methods that demonstrate intermediate and terminal stream operations.
 */

public class InventoryService {
    /**
     * Filters products by minimum quantity.
     */
    public List<Product> filterLowStock(List<Product> inventory, int minQty){
            return inventory.stream()
                    .filter(p -> p.getQuantity() < minQty) // Intermediate: filter
                    .collect(Collectors.toList()); // Terminal: collect
    }

    /**
     * Gets names of all products in upper-case.
     */
    public List<String> getProductNamesUpper(List<Product> inventory){
        return inventory.stream()
                .map(p -> p.getName().toUpperCase()) // Intermediate: map
                .distinct() // Intermediate: distinct - removes duplicate
                .sorted()   // Intermediate: sorted - orders alphabetically
                .collect(Collectors.toList()); // Terminal: collect - gathers into a list.
    }

    /**
     * Group products by category.
     */
    public Map<String, List<Product>> groupByCategory(List<Product> inventory){
        return inventory.stream()
                .collect(Collectors.groupingBy(Product::getCategory)); // Terminal: collect - grouping results By 'Product::getCategory'
    }

    /**
     * Partition products by perishability.
     */
    public Map<Boolean, List<Product>> partitionByPerishable(List<Product> inventory){
        return inventory.stream()
                .collect(Collectors.partitioningBy(Product::isPerishable)); // Terminal: collect -  partitioning s into two groups: true and false based on whether they’re perishable.
    }

    /**
     * Total inventory value using reduce.
     */
    public double calculateTotalValue(List<Product> inventory){
        // Check with if else, throw exceptions in such a case, then use stream
        return inventory.stream()
                .map(p -> p.getPrice() * p.getQuantity()) // Intermediate: map
                // p1 total price + p2 total price + ...etc.
                // total = 0.0
                // total = total + p1 total price, total = total + p2 total price, ...etc.
                .reduce(0.0, Double::sum); // Terminal: reduce
    }

    /**
     * Find product with max price.
     */
    public Optional<Product> findMostExpensive(List<Product> inventory){
       // Optional<Product>: Java's way of safely handling the possibility of absence (null safe alternative)
        // Why? because the list might be empty, then there is no product to be returned
        return inventory.stream()
                .max(Comparator.comparing(Product::getPrice)); // Terminal: max
    }
}
