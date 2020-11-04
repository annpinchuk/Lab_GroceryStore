package com.GroceryShop;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product p = (Product) o;
        return barcode == p.barcode;
    }

    public abstract void display();
}
