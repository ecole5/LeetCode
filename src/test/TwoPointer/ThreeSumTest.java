package TwoPointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    private ThreeSum runner = new ThreeSum();


    @Test
    void threeSumHashNoSort() {
        runner.threeSumHashNoSort(new int []{-1,0,1});
    }
}