package com.GroceryShop;

public class Pistol {
    private String model;
    private int caliber;

    public Pistol(String model, int caliber) {
        this.model = model;
        this.caliber = caliber;
    }

    public String getModel() {
        return model;
    }

    public int getCaliber() {
        return caliber;
    }
}
