package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> containsName = t -> t.getName().contains(key);
        Predicate<Person> containsSurname = t -> t.getSurname().contains(key);
        Predicate<Person> containsPhone = t -> t.getPhone().contains(key);
        Predicate<Person> containsAddress = t -> t.getAddress().contains(key);
        var combine = containsName.or(containsSurname).or(containsPhone).or(containsAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}