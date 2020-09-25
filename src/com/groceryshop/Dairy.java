package com.groceryshop;

import java.util.GregorianCalendar;

public class Dairy extends Product{
    private GregorianCalendar expiresAt;
    private int quantity;

    public Dairy(String name, double price, long barcode, GregorianCalendar expiresAt, int quantity) {
        super(name, price, barcode);
        this.expiresAt = expiresAt;
        this.quantity = quantity;
    }

    @Override
    public void display() {
        System.out.println("Dairy: " + name + ", expires at " + expiresAt.getTime() + ", " + price + ", (" + barcode + "), quantity: " + quantity);
    }
}
