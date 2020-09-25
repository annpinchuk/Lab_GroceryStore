package com.groceryshop;

public class Cashier extends Worker implements CashierInterface{

    public Cashier(String name) {
        super(name);
    }

    @Override
    public void sell(Product product) {
        System.out.println("Cashier name: " + name + " sold " + product.getName());
    }
}
