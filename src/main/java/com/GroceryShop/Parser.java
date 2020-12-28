package com.GroceryShop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parser {

    private static final Logger logger = LogManager.getLogger(Parser.class);

    public Product parseProduct(String str) {
        String[] parts = str.split(" ");

        if (parts.length < 3) {
            throw new NotParsableException();
        }

        double price;
        int barcode;

        try {
            price = Double.parseDouble(parts[parts.length - 2]);
            barcode = Integer.parseInt(parts[parts.length - 1]);
        } catch (Exception e) {
            throw new NotParsableException("Cannot parse: " + e.getClass() + ": " + e.getMessage());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length - 2; i++) {
            sb.append(parts[i]);
            sb.append(" ");
        }

        return new Product(sb.toString(), price, barcode) {
            @Override
            public void display() {
                logger.info("Product: " + name + ", " + price + ", (" + barcode + ")");
            }
        };
    }
}
