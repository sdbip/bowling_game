package bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoringTests {

    private final Game game = new Game();

    @Test
    void noRolls_noScore() {
        assertEquals(0, game.score());
    }

    @Test
    void oneRoll_scoreIsNumberOfPins() {
        game.roll(1);
        assertEquals(1, game.score());
    }

    @Test
    void twoRolls_scoreIsTotalNumberOfPins() {
        game.roll(1);
        game.roll(1);
        assertEquals(2, game.score());
    }
}
