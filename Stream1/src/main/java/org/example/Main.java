package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        orders.stream()
                .collect(Collectors.groupingBy(Order::product, Collectors.summingDouble(Order::cost)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(e -> System.out.println("Product: " + e.getKey() + ". Total cost: " + e.getValue()));
    }
    record Order(String product, double cost){}
}