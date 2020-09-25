package com.groceryshop;

import java.util.ArrayList;

public class Counter {
    private CounterType category;
    private ArrayList<Product> products;

    public Counter(CounterType category) {
        this.category = category;
        this.products = new ArrayList<>();
    }

    public CounterType getCategory() {
        return category;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }
}
