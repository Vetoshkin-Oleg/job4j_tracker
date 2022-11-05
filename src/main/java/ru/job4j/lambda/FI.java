package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Arrays.sort;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 200", 20),
                new Attachment("image 1", 120),
                new Attachment("image 30", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());

        sort(atts, comparator);
        for (Attachment att : atts) {
            System.out.println(att);
        }

        Comparator<String> cmpText = (left, right) -> {
            return left.compareTo(right);
        };

        Comparator<String> cmpDescSize = (left, right) -> {
            return Integer.compare(right.length(), left.length());
        };

    }
}