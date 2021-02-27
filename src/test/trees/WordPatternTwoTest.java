package trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordPatternTwoTest {

    private WordPatternTwo runner;

    @BeforeEach
    void setUp() {
        runner = new WordPatternTwo();
    }

    @Test
    void wordPatternMatch() {

       assertTrue(runner.wordPatternMatch("ab", "bobcob"));
        assertTrue(runner.wordPatternMatch("abab", "redblueredblue"));
        assertTrue(runner.wordPatternMatch("abc", "bdc"));
        assertFalse(runner.wordPatternMatch("aabb", "xyzabcxzyabc"));
        assertFalse(runner.wordPatternMatch("ab", "aa"));

    }
}