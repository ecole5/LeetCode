package graph;

import design.MinimumKnightMoves;
import org.junit.jupiter.api.Test;

class MinimumKnightMovesTest {

    MinimumKnightMoves runner = new MinimumKnightMoves();

    @Test
    void minKnightMoves() {
        runner.minKnightMoves(2,1);
    }
}