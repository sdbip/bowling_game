package bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoringTests {
    @Test
    void noRolls_noScore() {
        Game game = new Game();
        assertEquals(0, game.score());
    }

    @Test
    void oneRoll_scoreIsNumberOfPins() {
        Game game = new Game();
        game.roll(1);
        assertEquals(1, game.score());
    }

    @Test
    void teoRolls_scoreIsTotalNumberOfPins() {
        Game game = new Game();
        game.roll(1);
        game.roll(1);
        assertEquals(2, game.score());
    }

}
