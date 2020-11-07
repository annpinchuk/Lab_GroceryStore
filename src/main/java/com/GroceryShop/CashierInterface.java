package com.GroceryShop;

public interface CashierInterface {
    int getId();

    void sell(Product product);

    void sell(Product product, int count);
}
