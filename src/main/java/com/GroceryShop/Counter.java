package com.GroceryShop;

import java.util.ArrayList;

public class Counter {
    private CounterType type;
    protected ArrayList<Product> products;

    public Counter(CounterType type) {
        this.type = type;
        this.products = new ArrayList<>();
    }

    public Counter(CounterType type, ArrayList<Product> products) {
        this.type = type;
        this.products = products;
    }

    public CounterType getType() {
        return type;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (this.products.contains(product)) {
            System.out.println("This product is already on the counter!");
        } else {
            this.products.add(product);
        }
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
