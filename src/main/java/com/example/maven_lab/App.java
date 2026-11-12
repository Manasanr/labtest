package com.example.maven_lab;



public class App {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Laptop", 2, 50000);
        cart.addProduct("Mouse", 3, 500);
        cart.addProduct("Keyboard", 1, 1000);

        // Display cart
        System.out.println("----- SHOPPING CART -----");
        cart.displayCart();

        // Calculate total
        System.out.println("\nTotal Price: " +
                           cart.calculateTotal());

        // Apply discount
        System.out.println("\nAfter 10% Discount: " +
                           cart.applyDiscount(10));

        // Remove product
        cart.removeProduct("Mouse");

        // Display updated cart
        System.out.println("\n----- UPDATED CART -----");
        cart.displayCart();

        // Updated total
        System.out.println("\nUpdated Total: " +
                           cart.calculateTotal());
    }
}
