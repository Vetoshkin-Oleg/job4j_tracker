package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 200", 20),
                new Attachment("image 1", 120),
                new Attachment("image 30", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());

        Arrays.sort(atts, comparator);
        for (Attachment att : atts) {
            System.out.println(att);
        }

        Comparator<Attachment> cmpText = (left, right) ->
                (left.getName()).compareTo((right.getName()));

        System.out.println();
        Arrays.sort(atts, cmpText);
        for (Attachment att : atts) {
            System.out.println(att);
        }

        Comparator<Attachment> cmpDescSize = (left, right) ->
                Integer.compare(right.getName().length(), left.getName().length());

        System.out.println();
        Arrays.sort(atts, cmpDescSize);
        for (Attachment att : atts) {
            System.out.println(att);
        }
    }

}