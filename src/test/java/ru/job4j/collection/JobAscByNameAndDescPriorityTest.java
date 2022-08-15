package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

class JobAscByNameAndDescPriorityTest {
    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        Job jobD4 = new Job("DDD task", 4);
        Job jobB0 = new Job("XXX bug", 0);
        Job jobA1 = new Job("AAA bug", 1);
        Job jobD2 = new Job("DDD task", 2);
        Job jobT3 = new Job("XXX task", 0);
        List<Job> jobs = Arrays.asList(jobD4, jobB0, jobA1, jobD2, jobT3);
        jobs.sort(cmpNamePriority);
        List<Job> rsl = Arrays.asList(jobA1, jobD4, jobD2, jobB0, jobT3);
        assertThat(jobs).isEqualTo(rsl);
    }
}