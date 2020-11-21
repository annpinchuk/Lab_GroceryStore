package com.GroceryShop;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class CounterTest {
    @Test
    public void ProductsAreNotAddedTwiceToTheCounter() {
        GregorianCalendar date1 = new GregorianCalendar(2020, Calendar.SEPTEMBER, 30);
        Counter counter1 = new Counter(CounterType.Box);
        Fruits apples = new Fruits("Apple", 40.5, 4809745635L, 100);
        Fruits bananas = new Fruits("Banana", 25, 4806555478L, 300);
        Vegetables tomatoes = new Vegetables("Tomato", 15.25, 4806543645L, 150);
        Dairy milk_molokiya = new Dairy("Milk Molokiya", 25, 4806345645L, date1, 1000);
        Beverages fanta = new Beverages("Fanta", 12, 4804561237L, 400);

        counter1.addProduct(apples);
        counter1.addProduct(bananas);
        counter1.addProduct(apples);
        counter1.addProduct(tomatoes);
        counter1.addProduct(milk_molokiya);
        counter1.addProduct(fanta);

        assertEquals(counter1.getProducts(), new ArrayList<>(Arrays.asList(apples, bananas, tomatoes, milk_molokiya, fanta)));
    }

    @Test
    public void IsCounterDescriptionCorrect() {
        Counter counter1 = new Counter(CounterType.Box);
        Counter counter2 = new Counter(CounterType.Shelf);
        Counter counter3 = new Counter(CounterType.Fridge);

        assertEquals(counter1.getCategory().toString(), counter1.toString());
        assertEquals("Box (1 levels)", counter1.toString());
        assertEquals("Shelf (5 levels)", counter2.toString());
        assertEquals("Fridge (1 levels)", counter3.toString());
    }

    @Test
    public void IsCounterTypesDescriptionListCorrect() {
        assertEquals("Fridge (1 levels), Shelf (5 levels), Box (1 levels), ",CounterType.getList());
    }

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
