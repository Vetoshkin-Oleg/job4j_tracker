package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class JobDescByPriorityTest {

    @Test
    void whenComparatorDescByPriority() {
        Job job1 = new Job("AAA bug", 1);
        Job job4 = new Job("DDD task", 4);
        Job job2 = new Job("DDD bug", 2);
        Job job0 = new Job("XXX bug", 0);
        Job job3 = new Job("XXX task", 3);
        Job job5 = new Job("BBB task", 5);
        List<Job> jobs = Arrays.asList(job1, job4, job2, job0, job3, job5);
        jobs.sort(new JobDescByPriority());
        List<Job> rsl = Arrays.asList(job5, job4, job3, job2, job1, job0);
        assertThat(jobs).isEqualTo(rsl);
    }
}