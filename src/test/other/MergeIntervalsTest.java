package other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    MergeIntervals runner = new MergeIntervals();

    @Test
    void merge() {
        int [] [] test = { {1,3},{4,6}};
        Assertions.assertArrayEquals( runner.merge(test),test, "No overlap");

        Assertions.assertArrayEquals( runner.merge(new int[][] {{7,9},{4,6}}),new int[][] {{4,6},{7,9}}, "No overlap out of order");

        Assertions.assertArrayEquals( runner.merge(new int[][] {{7,9},{4,7}}),new int[][] {{4,9}}, "merge works");

        Assertions.assertArrayEquals( runner.merge(new int[][] {{7,9},{4,7}, {10,12}}),new int[][] {{4,9},{10,12}}, "merge works with one merge an no merge");



    }
}