package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

public class JobAscByPriorityAndDescNameTest {
    @Test
    public void whenComparatorByAscPriorityAndDescName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
        Job jobD4 = new Job("DDD task", 4);
        Job jobB0 = new Job("XXX bug", 0);
        Job jobA1 = new Job("AAA bug", 1);
        Job jobD2 = new Job("DDD task", 2);
        Job jobT3 = new Job("XXX task", 0);
        List<Job> jobs = Arrays.asList(jobD4, jobB0, jobA1, jobD2, jobT3);
        jobs.sort(cmpNamePriority);
        List<Job> rsl = Arrays.asList(jobT3, jobB0, jobA1, jobD2, jobD4);
        assertThat(jobs).isEqualTo(rsl);
    }
}
