package com.GroceryShop;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductRepository {
    Shop shop;

    public ProductRepository(Shop shop) {
        this.shop = shop;
    }

    protected Stream<Product> getProductStream(Predicate<Counter> predicate) {
        return shop.getCounters().stream()
                .filter(predicate)
                .flatMap(counter -> counter.getProducts().stream());
    }

    protected Stream<Product> getProductStream(CounterType counterType) {
        return getProductStream(checkCounterType(counterType));
    }

    protected Stream<Product> getProductStream() {
        return getProductStream(counter -> true);
    }

    public double getProductSum(CounterType counterType) {
        return getProductStream(counterType)
                .reduce(0.0,(productSum, product) -> productSum + product.price, Double::sum);
    }

    public Map<String, List<Product>> groupbyPrice(CounterType counterType) {
        return getProductStream(counterType)
                .collect(Collectors.groupingBy(product -> product.price > 12 ? "expensive" : "cheap"));
    }

    public Product getTheMostExpensiveProduct(CounterType counterType) {
        return getProductStream(counterType)
                .max(Comparator.comparing(Product::getPrice))
                .get();
    }

    public double getAveragePrice() {
        return getProductStream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(Double.NaN);
    }

    public static Predicate<Counter> checkCounterType(CounterType counterType) {
        return counter -> counter.getType() == counterType;
    }

}
