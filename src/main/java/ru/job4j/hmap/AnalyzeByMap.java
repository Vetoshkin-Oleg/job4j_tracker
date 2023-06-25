package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
            if (count != 0) {
                Label label = new Label(pupil.name(), score / count);
                result.add(label);
            }
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectsScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject: pupil.subjects()) {
                subjectsScores.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> subjectScore : subjectsScores.entrySet()) {
            labels.add(new Label(subjectScore.getKey(), (double) subjectScore.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> listPupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            Label label = new Label(pupil.name(), score);
            listPupil.add(label);
        }
        listPupil.sort(Comparator.naturalOrder());
        return listPupil.get(listPupil.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectsScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject: pupil.subjects()) {
                subjectsScores.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> subjectScore : subjectsScores.entrySet()) {
            labels.add(new Label(subjectScore.getKey(), subjectScore.getValue()));
        }
        Collections.sort(labels);
        return labels.size() > 0 ? labels.get(labels.size() - 1) : null;
    }
}
