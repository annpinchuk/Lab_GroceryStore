package com.GroceryShop;

public class Fruits extends Product {
    private float weight;

    public Fruits(String name, double price, long barcode, float weight) {
        super(name, price, barcode);
        this.weight = weight;
    }

    @Override
    public void display() {
        System.out.println("Fruit: " + name + " has weight " + weight + ", " + price + "/kg, (" + barcode + ")");
    }
}
