package com.GroceryShop;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ProductRepositoryTest {
    ProductRepository productRepository;

    @Before
    public void initObjects() {
        GregorianCalendar date1 = new GregorianCalendar(2020, Calendar.SEPTEMBER, 30);
        GregorianCalendar date2 = new GregorianCalendar(2020, Calendar.SEPTEMBER, 28);
        Shop shop = new Shop("Novus", 1500);
        Counter counter1 = new Counter(CounterType.Box);
        Counter counter2 = new Counter(CounterType.Fridge);
        Counter counter3 = new Counter(CounterType.Shelf);
        Counter counter4 = new Counter(CounterType.Shelf);

        shop.addCounter(counter1);
        shop.addCounter(counter2);
        shop.addCounter(counter3);
        shop.addCounter(counter4);

        Fruits apples = new Fruits("Apple", 40.5, 4809745635L, 100);
        Fruits bananas = new Fruits("Banana", 25, 4806555478L, 300);
        Vegetables cucumber = new Vegetables("Cucumber", 15.25, 4806555645L, 400);
        Vegetables tomatoes = new Vegetables("Tomato", 15.25, 4806543645L, 150);
        Dairy milk_molokiya = new Dairy("Milk Molokiya", 25, 4806345645L, date1, 1000);
        Dairy yogurt_activia = new Dairy("Yogurt Activia", 32, 4806341234L, date2, 500);
        Beverages coca_cola = new Beverages("Coca Cola", 15, 4804561234L, 600);
        Beverages fanta = new Beverages("Fanta", 12, 4804561237L, 400);

        counter1.addProduct(apples);
        counter1.addProduct(bananas);
        counter1.addProduct(cucumber);
        counter1.addProduct(tomatoes);
        counter2.addProduct(milk_molokiya);
        counter2.addProduct(yogurt_activia);
        counter3.addProduct(coca_cola);
        counter3.addProduct(fanta);

        productRepository = new ProductRepository(shop);
    }

    @Test
    public void GetProductStreamShouldReturnAllProducts() {
        var resultStream = productRepository.getProductStream();

        assertEquals(resultStream.count(), 8);
    }

    @Test
    public void GetProductStreamShouldReturnAllProductsFromCounter() {
        var resultStream = productRepository.getProductStream(CounterType.Box);

        assertEquals(resultStream.count(), 4);
    }
    @Test
    public void GetProductSumShouldReturnRightValue() {
        var result = productRepository.getProductSum(CounterType.Box);

        assertEquals(result, 96.0, 0.01);
    }

    @Test
    public void GroupByPriceShouldReturnRightMap() {
        var result = productRepository.groupbyPrice(CounterType.Shelf);

        assertEquals(result.get("expensive").size(), 1);
        assertEquals(result.get("cheap").size(), 1);
    }
}
