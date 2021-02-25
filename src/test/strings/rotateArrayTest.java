package strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class rotateArrayTest {

    private rotateArray test;

    @BeforeEach
    void setUp() {
        rotateArray test = new rotateArray();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void rotate() {
        int [] arrray = {1,2,3};
        test.rotate(arrray,3);
        assertArrayEquals(new int[] {1,2,3}, arrray);
    }
}