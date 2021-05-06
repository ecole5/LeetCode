package graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderIITest {

    WordLadderII runner = new WordLadderII();

    @Test
    void findLadders() {
        //runner.findLadders("cool","tooc", Arrays.asList("cool","tooc", "tool", "cooc", "fool"));
        runner.findLadders("a","c", Arrays.asList("a","b","c"));
    }
}