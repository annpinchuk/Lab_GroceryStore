package com.GroceryShop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Counter {
    private CounterType type;
    protected ArrayList<Product> products;

    private static final Logger logger = LogManager.getLogger(Counter.class);

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
            logger.info("This product is already on the counter!");
        } else {
            this.products.add(product);
        }
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
