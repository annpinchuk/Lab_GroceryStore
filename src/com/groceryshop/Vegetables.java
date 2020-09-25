package com.groceryshop;

public class Vegetables extends Product {
    private float weight;

    public Vegetables(String name, double price, long barcode, float weight) {
        super(name, price, barcode);
        this.weight = weight;
    }

    @Override
    public void display() {
        System.out.println("Vegetable: " + name + " has weight " + weight + ", " + price + "/kg, (" + barcode + ")");
    }
}
