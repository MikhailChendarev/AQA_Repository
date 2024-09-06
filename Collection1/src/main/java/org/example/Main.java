package org.example;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static <T> List<T> filter(T[] array, Filter filter) {
        List<T> result = new ArrayList<>();
        for (T element : array) {
            if ((Boolean)filter.apply(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Filter evenFilter = o -> (Integer) o % 2 == 0;

        List<Integer> evenNumbers = filter(numbers, evenFilter);
        System.out.println(evenNumbers);
    }
}
