package com.GroceryShop;

public class Cashier extends Worker implements CashierInterface{
    private int cashboxId;

    public Cashier(String name) {
        super(name);
    }

    public Cashier(String name, int cashboxId) {
        super(name);
        this.cashboxId = cashboxId;
    }

    @Override
    public int getId() {
        return cashboxId;
    }

    @Override
    public String sell(Product product) {
        return "Cashier name: " + name + " sold " + product.getName();
    }

    @Override
    public String sell(Product product, int count) {
        return "Cashier name: " + name + " sold " + product.getName() + " x " + count;
    }
}
