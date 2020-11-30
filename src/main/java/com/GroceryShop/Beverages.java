package com.GroceryShop;

public class Beverages extends Product {
    protected int quantity;

    public Beverages(String name, double price, long barcode, int quantity) {
        super(name, price, barcode);
        this.quantity = quantity;
    }

    @Override
    public void display() {
        System.out.println("Beverages: " + name + ", " + price + ", (" + barcode + "), quantity: " + quantity);
    }
}
