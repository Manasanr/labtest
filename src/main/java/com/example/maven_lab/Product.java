
package com.example.maven_lab;

public class Product {

    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Invalid price");
        }

        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void addQuantity(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        this.quantity += quantity;
    }

    public double getTotalPrice() {
        return quantity * price;
    }
}
