package bowling;

class Game {
    private static final int ALL_PINS = 10;

    private final int[] rolls = new int[5];
    private int currentRoll = 0;

    void roll(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    int score() {
        int score = 0;
        for (int framingRoll = 0; framingRoll < rolls.length - 1; framingRoll += 2) {
            if (isStrike(framingRoll)) {
                score += ALL_PINS + strikeBonus(framingRoll);
                framingRoll--;
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
