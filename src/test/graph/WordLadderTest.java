package graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {


    WordLadder runner = new WordLadder();



    @Test
    void testLadderLength() {
        runner.ladderLength("cool","cooe",Arrays.asList("cool","fool", "ceol"));

    }
}