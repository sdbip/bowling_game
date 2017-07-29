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
        rollFrame(1, 1);
        assertEquals(2, game.score());
    }

    @Test
    void rollSpare_bonusFromNextRoll() {
        rollFrame(0, 10); // spare
        game.roll(3);
        assertEquals(16, game.score());
    }

    @Test
    void fourRolls_allAreCounted() {
        rollFrame(3, 4);
        rollFrame(5, 3);
        assertEquals(15, game.score());
    }

    @Test
    void notSpare_noBonus() {
        rollFrame(3, 5);
        rollFrame(5, 3);
        assertEquals(16, game.score());
    }

    @Test
    void strike_bonusFromNextTwoRolls() {
        rollStrike();
        rollFrame(3, 4);
        assertEquals(24, game.score());
    }

    @Test
    void perfectGame_scoreIs300() {
        for (int i = 0; i < 12; i++)
            rollStrike();
        assertEquals(300, game.score());
    }

    @Test
    void strikeOnLastFrame_causes21Rolls() {
        for (int i = 0; i < 9; i++) {
            rollFrame(0, 0);
        }
        rollStrike();
        rollStrike(); // bonus roll
        rollStrike(); // bonus roll
        assertEquals(30, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollFrame(int firstRoll, int secondRoll) {
        game.roll(firstRoll);
        game.roll(secondRoll);
    }
}
