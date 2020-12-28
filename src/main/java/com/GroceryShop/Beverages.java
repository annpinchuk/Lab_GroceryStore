package com.GroceryShop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Beverages extends Product {
    protected int quantity;

    private static final Logger logger = LogManager.getLogger(Beverages.class);

    public Beverages(String name, double price, long barcode, int quantity) {
        super(name, price, barcode);
        this.quantity = quantity;
    }

    @Override
    public void display() {
        logger.info("Beverages: " + name + ", " + price + ", (" + barcode + "), quantity: " + quantity);
    }
}
