package com.GroceryShop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("CounterTypes: " + CounterType.getList());

        Parser parser = new Parser();
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

        if(counter3.equals(counter4)){
            logger.debug("Counters are equal!");
        }else{
            logger.debug("Counters are not equal!");
        }

        Product p1;
        try {
            p1 = parser.parseProduct("Yogurt Molokiya 40.5 1233123123");
        } catch (NotParsableException e) {
            logger.info(e.getMessage());
        } finally {
            p1 = new Dairy("Yogurt Molokiya", 40.5, 1233123123, date1, 1000);
        }

        Product p2;
        try {
            p2 = parser.parseProduct("Sprite test 12 ");
        } catch (NotParsableException e) {
            logger.error(e.getMessage());
        } finally {
            p2 = new Beverages("Sprite", 12, 34234234, 400);
        }

        Fruits apples = new Fruits("Apple", 40.5, 4809745635L, 100);
        Fruits bananas = new Fruits("Banana", 25, 4806555478L, 300);
        Vegetables cucumber = new Vegetables("Cucumber", 15.25, 4806555645L, 400);
        Vegetables tomatoes = new Vegetables("Tomato", 15.25, 4806543645L, 150);
        Dairy milk_molokiya = new Dairy("Milk Molokiya", 25, 4806345645L, date1, 1000);
        Dairy yogurt_activia = new Dairy("Yogurt Activia", 32, 4806341234L, date2, 500);
        Beverages coca_cola = new Beverages("Coca Cola", 15, 4804561234L, 600);
        Beverages fanta = new Beverages("Fanta", 12, 4804561237L, 400);

        counter1.addProduct(apples);
        counter1.addProduct(apples);
        counter1.addProduct(bananas);
        counter1.addProduct(cucumber);
        counter1.addProduct(tomatoes);
        counter2.addProduct(p1);
        counter2.addProduct(milk_molokiya);
        counter2.addProduct(yogurt_activia);
        counter3.addProduct(coca_cola);
        counter3.addProduct(fanta);
        counter3.addProduct(p2);

        SecurityGuard security1 = new SecurityGuard("Vasya");
        Merchandiser merch1 = new Merchandiser("Natasha");
        merch1.addCounter(counter1);
        merch1.addCounter(counter2);
        Cashier cashier1 = new Cashier("Tamara");
        Cashier cashier2 = new Cashier("Vlada", 2);

        shop.addWorker(security1);
        shop.addWorker(merch1);
        shop.addWorker(cashier1);
        shop.addWorker(cashier2);

        showShop(shop);

        logger.info(cashier1.sell(apples));
        logger.info(cashier1.sell(yogurt_activia, 5));

        ProductRepository productRepository = new ProductRepository(shop);
        logger.info(productRepository.getProductSum(CounterType.Box));
        Map<String, List<Product>> map = productRepository.groupbyPrice(CounterType.Shelf);

        map.forEach((key, value) -> {
            logger.info(key + ": ");
            for (Product product: value) {
                product.display();
            }
        });

        Product expensiveProduct = productRepository.getTheMostExpensiveProduct(CounterType.Shelf);
        logger.info("The most expensive product: ");
        expensiveProduct.display();

        logger.info("Average sum of all products: " + productRepository.getAveragePrice());

    }

    private static void showShop(Shop shop) {
        logger.info("Grocery store name: " + shop.getName());

        StringBuilder sb = new StringBuilder();
        for (Counter counter : shop.getCounters()) {
            sb.append(counter);
            sb.append(", ");

            logger.info("- " + counter.getType() + " products:");
            Iterator<Product> iterator = counter.getProducts().iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                product.display();
            }
        }
        logger.info("Shop counters: " + sb);
        logger.info("Workers: ");
        for (Worker worker : shop.getWorkers()) {
            logger.info("- " + worker.getName() + "");
            if (worker instanceof Merchandiser) {
                for (Counter counter : ((Merchandiser) worker).getCounters()) {
                    logger.info("--- " + counter.getType());
                }
            }
        }
    }

}
