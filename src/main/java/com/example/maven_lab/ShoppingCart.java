
package com.example.maven_lab;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products;

    // Constructor
    public ShoppingCart() {
        products = new ArrayList<>();
    }

    // Add product
    public void addProduct(String name, int quantity, double price) {

        Product newProduct = new Product(name, quantity, price);

        for (Product p : products) {

            if (p.getName().equalsIgnoreCase(name)) {

                if (p.getPrice() != price) {
                    throw new IllegalArgumentException(
                        "Different price for existing product"
                    );
                }

                p.addQuantity(quantity);
                return;
            }
        }

        products.add(newProduct);
    }

    // Remove product
    public void removeProduct(String name) {

        boolean removed = products.removeIf(
            p -> p.getName().equalsIgnoreCase(name)
        );

        if (!removed) {
            throw new IllegalArgumentException(
                "Product not found"
            );
        }
    }

    // Calculate total
    public double calculateTotal() {

        double total = 0;

        for (Product p : products) {
            total += p.getTotalPrice();
        }

        return total;
    }

    // Apply discount
    public double applyDiscount(double percentage) {

        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException(
                "Invalid discount percentage"
            );
        }

        double total = calculateTotal();

        double discount = total * percentage / 100;

        return total - discount;
    }

    // Display cart
    public void displayCart() {

        if (products.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        for (Product p : products) {

            System.out.println(
                p.getName() +
                " | Quantity: " + p.getQuantity() +
                " | Price: " + p.getPrice() +
                " | Total: " + p.getTotalPrice()
            );
        }
    }
}
