package ru.job4j.api;

import java.util.stream.Stream;

public class TakeWhile {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4)
                .takeWhile(v -> v < 3)
                .map(v -> "Результат: " + v)
                .forEach(System.out::println);
    }
}