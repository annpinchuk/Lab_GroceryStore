package com.GroceryShop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.GregorianCalendar;

public class Dairy extends Product{
    private GregorianCalendar expiresAt;
    private int quantity;

    private static final Logger logger = LogManager.getLogger(Dairy.class);

    public Dairy(String name, double price, long barcode, GregorianCalendar expiresAt, int quantity) {
        super(name, price, barcode);
        this.expiresAt = expiresAt;
        this.quantity = quantity;
    }

    @Override
    public void display() {
        logger.info("Dairy: " + name + ", expires at " + expiresAt.getTime() + ", " + price + ", (" + barcode + "), quantity: " + quantity);
    }
}
