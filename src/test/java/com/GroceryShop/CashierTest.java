package com.GroceryShop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashierTest {
    @Test
    public void cashierConstructor() {
        String tamara = "Tamara";
        String vlada = "Vlada";
        int cashboxId = 2;

        Cashier cashier1 = new Cashier(tamara);
        Cashier cashier2 = new Cashier(vlada, cashboxId);

        assertEquals(tamara, cashier1.name);
        assertEquals(vlada, cashier2.name);
        assertEquals(cashboxId, cashier2.getId());
    }
}
