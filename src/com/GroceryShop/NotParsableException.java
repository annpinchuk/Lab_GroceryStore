package com.GroceryShop;

public class NotParsableException extends IllegalArgumentException {
    public NotParsableException() {
        super("Not enough data in string to parse");
    }

    public NotParsableException(String s) {
        super(s);
    }
}
