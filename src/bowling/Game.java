package bowling;

class Game {
    private static final int ALL_PINS = 10;

    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    void roll(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    int score() {
        int score = 0;
        int strikes = 0;
        for (int i = 0; i < rolls.length - 1; i += 2) {
            int framingRoll = i - strikes;
            if (isStrike(framingRoll)) {
                score += ALL_PINS + strikeBonus(framingRoll);
                strikes++;
            }
            else if (isSpare(framingRoll))
                score += ALL_PINS + spareBonus(framingRoll);
            else
                score += rolls[framingRoll] + rolls[framingRoll + 1];
        }
        return score;
    }

    private boolean isStrike(int framingRoll) {
        return rolls[framingRoll] == ALL_PINS;
    }

    private int strikeBonus(int framingRoll) {
        return rolls[framingRoll + 1] + rolls[framingRoll + 2];
    }

    private boolean isSpare(int framingRoll) {
        return rolls[framingRoll] + rolls[framingRoll + 1] == ALL_PINS;
    }

    private int spareBonus(int framingRoll) {
        return rolls[framingRoll + 2];
    }
}
