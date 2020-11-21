package com.GroceryShop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShopTest {
    @Test
    public void AreCountersAddedToShop() {
        Shop shop = new Shop("Novus", 1500);
        Counter counter1 = new Counter(CounterType.Box);
        Counter counter2 = new Counter(CounterType.Fridge);
        Counter counter3 = new Counter(CounterType.Shelf);

        shop.addCounter(counter1);
        shop.addCounter(counter2);
        shop.addCounter(counter3);

        assertEquals(shop.getCounters(), new ArrayList<>(Arrays.asList(counter1,counter2, counter3)));
    }

    @Test
    public void AreWorkersAddedToShop() {
        Shop shop = new Shop("Novus", 1500);
        SecurityGuard security1 = new SecurityGuard("Vasya");
        Cashier cashier1 = new Cashier("Tamara");

        shop.addWorker(security1);
        shop.addWorker(cashier1);

        assertEquals(shop.getWorkers(), new ArrayList<>(Arrays.asList(security1,cashier1)));
    }
}
