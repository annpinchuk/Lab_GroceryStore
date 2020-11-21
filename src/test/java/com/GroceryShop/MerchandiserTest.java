package com.GroceryShop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MerchandiserTest {
    @Test
    public void AreCountersAddedToMerchandiser() {
        Counter counter1 = new Counter(CounterType.Box);
        Counter counter2 = new Counter(CounterType.Shelf);
        Counter counter3 = new Counter(CounterType.Fridge);
        Merchandiser merch1 = new Merchandiser("Natasha");

        merch1.addCounter(counter1);
        merch1.addCounter(counter2);
        merch1.addCounter(counter3);

        assertEquals(merch1.getCounters(), new ArrayList<>(Arrays.asList(counter1, counter2, counter3)));
    }
}
