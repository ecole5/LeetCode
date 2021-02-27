package heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KClosestPointtoOriginTest {

    KClosestPointtoOrigin runner = new KClosestPointtoOrigin();


    @Test
    void kClosest() {
        int[][] cool = {{1,3},{-2,2}};
        runner.kClosest(cool,1);
        int[][] cool2 = {{1,2},{1,2}};
        runner.kClosest(cool2,1);
        int[][] cool3 = {{1,1},{4,4}};
        runner.kClosest(cool3,1);
    }
}