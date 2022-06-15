package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(origin));
        for (String string : text) {
            if (!set.contains(string)) {
                return false;
            }
        }
        return rsl;
    }
}