package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        int index = 0;
        for (String string: value) {
            if (string.equals(key)) {
                rsl = index;
                break;
            }
            index++;
        }
        if (rsl == -1) {
            throw new ElementNotFoundException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "two"};
        try {
            indexOf(array, "two2");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}