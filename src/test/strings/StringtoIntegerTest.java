package strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringtoIntegerTest {

    private StringtoInteger runner = new StringtoInteger();

    @Test
    void myAtoi() {
        Assertions.assertEquals(10,runner.myAtoi(" +10"), "White space works");
        Assertions.assertEquals(10,runner.myAtoi("+10"), "Positive sign handeling works");
        Assertions.assertEquals(-10,runner.myAtoi("-10"), "negative sign handeling works");
        Assertions.assertEquals(10,runner.myAtoi("10"), "no sign handeling works");
        Assertions.assertEquals(10,runner.myAtoi("10ABD"), "character after digetsd work");
        Assertions.assertEquals(10,runner.myAtoi("10ABD"), "character after digetsd work");
        Assertions.assertEquals(0,runner.myAtoi(""), "empty work");
        Assertions.assertEquals(0,runner.myAtoi("-ABC"), "no diget works");
        Assertions.assertEquals(0,runner.myAtoi("-"), "just sign work");
        Assertions.assertEquals(Integer.MIN_VALUE,runner.myAtoi("-2147483650"), "min value clamping");
        Assertions.assertEquals(Integer.MAX_VALUE,runner.myAtoi("2147483660"), "max value clamping");
        Assertions.assertEquals(Integer.MIN_VALUE,runner.myAtoi("-2147483649"), "min value clamping");
        Assertions.assertEquals(Integer.MAX_VALUE,runner.myAtoi("2147483648"), "exception occurs at 2^31-1");
        Assertions.assertEquals(0,runner.myAtoi(" "), "empty");

    }
}