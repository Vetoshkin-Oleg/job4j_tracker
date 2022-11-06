package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, 0, 5, -4, 4, 0, 3, -3, 1, -1, 0, 2, -2);
        List<Integer> positive = numbers.stream().filter(
                task -> task > 0
                ).collect(
                        Collectors.toList()
        );
        positive.forEach(System.out::println);
    }
}