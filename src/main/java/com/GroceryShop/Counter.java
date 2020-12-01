package com.GroceryShop;

import java.util.ArrayList;

public class Counter {
    private CounterType category;
    protected ArrayList<Product> products;

    public Counter(CounterType category) {
        this.category = category;
        this.products = new ArrayList<>();
    }

    public Counter(CounterType category, ArrayList<Product> products) {
        this.category = category;
        this.products = products;
    }

    public CounterType getCategory() {
        return category;
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
        return category.toString();
    }
}
