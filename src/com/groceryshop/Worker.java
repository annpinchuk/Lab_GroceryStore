package com.groceryshop;

public abstract class Worker {
    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
