package bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoringTests {
    @Test
    void noRolls_noScore() {
        Game game = new Game();
        assertEquals(0, game.score());
    }
}
