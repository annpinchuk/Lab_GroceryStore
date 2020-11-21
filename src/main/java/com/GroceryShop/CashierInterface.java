package com.GroceryShop;

public interface CashierInterface {
    int getId();

    String sell(Product product);

    String sell(Product product, int count);
}
