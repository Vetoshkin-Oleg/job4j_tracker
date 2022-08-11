package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    void compareDescByName() {
        Item item1 = new Item(1, "one");
        Item item2 = new Item(2, "two");
        Item item6 = new Item(6, "six");
        Item item4 = new Item(4, "four");

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item6);
        items.add(item4);
        items.sort(new ItemDescByName());

        List<Item> expected = new ArrayList<>();
        expected.add(item2);
        expected.add(item6);
        expected.add(item1);
        expected.add(item4);

        assertEquals(expected, items);
    }
}