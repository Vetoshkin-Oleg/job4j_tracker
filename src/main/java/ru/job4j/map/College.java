package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject2>> students;

    public College(Map<Student, Set<Subject2>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl;
        rsl = students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst();
        return rsl;
    }

    public Optional<Subject2> findBySubjectName(String account, String name) {
        Optional<Student> a = findByAccount(account);
        Optional<Subject2> rsl = Optional.empty();
        if (a.isPresent()) {
            return students.get(a)
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst();
        }
        return rsl;
    }

}