package com.GroceryShop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CashierIT {
    @Test
    public void DoesSellMethodReturnRightString() {
        Cashier cashier1 = new Cashier("Tamara");
        Fruits fruits = mock(Fruits.class);

        when(fruits.getName()).thenReturn("Apples").thenReturn("Bananas");

        assertEquals(cashier1.sell(fruits), "Cashier name: Tamara sold Apples");
        assertEquals(cashier1.sell(fruits, 2), "Cashier name: Tamara sold Bananas x 2");

        verify(fruits, times(2)).getName();
    }
}
