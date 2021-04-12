package general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertIntervalTest {

    private static final InsertInterval runner = new InsertInterval();

    @Test
    void insert() {
        Assertions.assertArrayEquals(new int[][] {{1,5},{6,9}},runner.insert(new int[][] {{1,3},{6,9}}, new int[]{2,5}));

    }
}