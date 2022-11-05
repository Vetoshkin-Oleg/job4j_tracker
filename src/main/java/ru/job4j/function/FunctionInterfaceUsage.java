package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        System.out.println("0");
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        System.out.println("00");
        Supplier<Set<String>> sup = () -> new HashSet<>(list);
        System.out.println("000");
        BiConsumer<Integer, String> consumer = (s, s1) -> {
            System.out.println("1111");
            System.out.println(s + s1 + "_333_");
            System.out.println("2222");
        };
        System.out.println("0000");
        Set<String> strings = sup.get();
        System.out.println("00000");
        int i = 1;
        System.out.println("000000");
        for (String s : strings) {
            System.out.println("3333");
            consumer.accept(i++, " is " + s);
            System.out.println("4444");
        }
        System.out.println("0000000");
        System.out.println("_____________________________________________________");

        List<String> list1 = List.of("one-", "two-", "three-", "one-", "two-", "three-");
        System.out.println("111");
        Supplier<Set<String>> supplier = () -> {
            System.out.println("222");
            return new HashSet<>(list1);
        };
        System.out.println("333");
        Set<String> strings1 = supplier.get();
        System.out.println("444");
        for (String s : strings1) {
            System.out.println("555");
            System.out.println(s);
            System.out.println("666");
        }
        System.out.println("_____________________________________________________");

    }
}