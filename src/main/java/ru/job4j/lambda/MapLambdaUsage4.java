package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapLambdaUsage4 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        Function<String, Integer> function = String::length;
        System.out.println("Result: " + map.computeIfAbsent("Petr", function));
        System.out.println("Result: " + map.computeIfAbsent("Petr", key -> key.length() + 10));
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
    }
}