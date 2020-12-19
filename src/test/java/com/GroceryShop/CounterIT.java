package com.GroceryShop;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class CounterIT {
    @Test
    public void AreProductsAddedToList() {
        ArrayList<Product> list = spy(new ArrayList<>());
        Counter counter = new Counter(CounterType.Box, list);
        Fruits apples = new Fruits("Apple", 40.5, 4809745635L, 100);
        Fruits bananas = new Fruits("Banana", 25, 4806555478L, 300);

        counter.addProduct(apples);
        counter.addProduct(bananas);

        verify(list).add(apples);
        verify(list).add(bananas);

        assertEquals(2, list.size());
    }
}
