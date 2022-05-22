package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException();
    }

    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "two"};
        try {
            indexOf(array, "two");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}