package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        System.out.println(method(array));
        String[] strings = {"1", "2", "2", "3", "3", "3", "4", "4", "4", "4"};
        System.out.println(method(strings));
    }

    public static <T> Map<T, Integer> method(T[] elements) {
        Map<T, Integer> map = new HashMap<>();
        for (T element : elements) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        return map;
    }
}