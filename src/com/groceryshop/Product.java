package com.groceryshop;

public abstract class Product {
    protected String name;
    protected double price;
    protected long barcode;

    public String getName() {
        return name;
    }

    public Product(String name, double price, long barcode) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }

    public abstract void display();
}
