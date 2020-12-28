package com.GroceryShop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fruits extends Product {
    private float weight;

    private static final Logger logger = LogManager.getLogger(Fruits.class);

    public Fruits(String name, double price, long barcode, float weight) {
        super(name, price, barcode);
        this.weight = weight;
    }

    @Override
    public void display() {
        logger.info("Fruit: " + name + " has weight " + weight + ", " + price + "/kg, (" + barcode + ")");
    }
}
