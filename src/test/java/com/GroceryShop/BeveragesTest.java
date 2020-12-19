package com.GroceryShop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeveragesTest {
    @Test
    public void IsTheInfoAboutProductAddedCorrectly() {
        String coca_cola1 = "Coca Cola";
        int price = 15;
        long barcode = 4804561234L;
        int quantity = 600;

        Beverages coca_cola = new Beverages(coca_cola1, price, barcode, quantity);

        assertEquals(coca_cola1, coca_cola.name);
        assertEquals(price, coca_cola.price, 0.01);
        assertEquals(barcode, coca_cola.barcode);
        assertEquals(quantity, coca_cola.quantity);
    }
}
