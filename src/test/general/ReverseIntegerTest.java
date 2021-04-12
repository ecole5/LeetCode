package general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseIntegerTest {

    private ReverseInteger runner = new ReverseInteger();

    @Test
    void reverse() {
        Assertions.assertEquals(43,runner.reverse(34), "Positive");
        Assertions.assertEquals(-43,runner.reverse(-34),"negative");
    }
}