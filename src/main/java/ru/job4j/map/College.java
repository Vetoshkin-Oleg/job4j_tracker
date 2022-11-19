package ru.job4j.map;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject2>> students;

    public College(Map<Student, Set<Subject2>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        List<Student> studentList;
        studentList = students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account)).toList();
        if (studentList.size() != 0) {
            rsl = Optional.of(studentList.get(0));
        }
        return rsl;
    }

    public Optional<Subject2> findBySubjectName(String account, String name) {
        Optional<Student> a = findByAccount(account);
        Optional<Subject2> rsl = Optional.empty();
        List<Subject2> subject2List = null;
        if (a.isPresent()) {
            subject2List = students.get(a)
                    .stream()
                    .filter(s -> s.getName().equals(name)).toList();
        }
        assert subject2List != null;
        if (subject2List.size() != 0) {
            rsl = Optional.of(subject2List.get(0));
        }
        return rsl;
    }

}