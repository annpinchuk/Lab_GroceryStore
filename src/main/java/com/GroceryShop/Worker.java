package com.GroceryShop;

public abstract class Worker {
    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
