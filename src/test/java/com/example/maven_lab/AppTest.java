
package com.example.maven_lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // Test 1: Add product
    @Test
    public void testAddProduct() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 2, 50000);

        assertEquals(100000, cart.calculateTotal(), 0.001);
    }

    // Test 2: Remove product
    @Test
    public void testRemoveProduct() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Mouse", 2, 500);

        cart.removeProduct("Mouse");

        assertEquals(0, cart.calculateTotal(), 0.001);
    }

    // Test 3: Calculate total
    @Test
    public void testCalculateTotal() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 2, 50000);
        cart.addProduct("Mouse", 3, 500);
        cart.addProduct("Keyboard", 1, 1000);

        assertEquals(102500, cart.calculateTotal(), 0.001);
    }

    // Test 4: Apply discount
    @Test
    public void testApplyDiscount() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 2, 50000);

        assertEquals(90000, cart.applyDiscount(10), 0.001);
    }

    // Test 5: Invalid quantity
    @Test
    public void testInvalidQuantity() {

        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct("Laptop", 0, 50000);
        });
    }

    // Test 6: Invalid price
    @Test
    public void testInvalidPrice() {

        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct("Laptop", 2, -500);
        });
    }

    // Test 7: Invalid discount
    @Test
    public void testInvalidDiscount() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 1, 50000);

        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscount(110);
        });
    }

    // Test 8: Remove non-existing product
    @Test
    public void testRemoveNonExistingProduct() {

        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeProduct("Mobile");
        });
    }

    // Test 9: Add same product twice
    @Test
    public void testAddSameProduct() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Mouse", 2, 500);
        cart.addProduct("Mouse", 3, 500);

        assertEquals(2500, cart.calculateTotal(), 0.001);
    }
}
