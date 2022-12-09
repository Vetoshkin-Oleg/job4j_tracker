package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        /* List<Integer> list = (List<Integer>) stream.map(o -> o.subjects())
                .flatMap(o -> o.stream())
                .mapToInt(o -> o.score())
                .collect(Collectors.toList());

        System.out.println(list); */
        return 0D;

    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return List.of();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }

    public static void main(String[] args) {
        Pupil ivanov = new Pupil("Ivanov",
                List.of(
                        new Subject("Math", 100),
                        new Subject("Lang", 70),
                        new Subject("Philosophy", 80)
                )
        );

        Pupil petrov = new Pupil("Petrov",
                List.of(
                        new Subject("Math", 80),
                        new Subject("Lang", 90),
                        new Subject("Philosophy", 70)
                )
        );

        Pupil sidorov = new Pupil("Sidorov",
                List.of(
                        new Subject("Math", 70),
                        new Subject("Lang", 60),
                        new Subject("Philosophy", 50)
                )
        );

        List<Pupil> list = List.of(ivanov, petrov, sidorov);
        Analyze.averageScore(list.stream());
    }
}