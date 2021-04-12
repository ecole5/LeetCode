package general;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class rotateArrayTest {

    private rotateArray runner;

    @BeforeEach
    void setUp() {
        runner = new rotateArray();
    }

    @Test
    void rotate() {
        int[] test = {1,2,3};
        runner.rotate(test,3);
        assertArrayEquals(new int[]{1,2,3},test);
    }
}

