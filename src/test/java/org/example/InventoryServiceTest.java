package org.example;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Unit tests for InventoryService.
 */
public class InventoryServiceTest {

    private InventoryService service;
    private List<Product> sampleInventory;

    @BeforeEach
    void setUp() {
        service = new InventoryService();
        sampleInventory = Arrays.asList(
                new Product("Milk", "Dairy", 1.5, 50, true),
                new Product("Cheese", "Dairy", 4.0, 20, true),
                new Product("Apple", "Fruit", 0.5, 200, true),
                new Product("Soap", "Non-Food", 3.0, 80, false)
        );
    }

    @Test
    void testFilterLowStock() {
        List<Product> lowStock = service.filterLowStock(sampleInventory, 60);
        assertEquals(2, lowStock.size());
    }

    @Test
    void testCalculateTotalValue() {
        double totalValue = service.calculateTotalValue(sampleInventory);
        assertEquals(1.5*50 + 4.0*20 + 0.5*200 + 3.0*80, totalValue);
    }

    @Test
    void testFindMostExpensive() {
        assertTrue(service.findMostExpensive(sampleInventory).isPresent());
        assertEquals("Cheese", service.findMostExpensive(sampleInventory).get().getName());
    }


}
