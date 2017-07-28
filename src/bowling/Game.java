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
            if (rolls[framingRoll] == ALL_PINS) { // strike
                score += ALL_PINS + rolls[framingRoll + 1] + rolls[framingRoll + 2];
                framingRoll--;
                continue;
            }
            if (isSpare(framingRoll) == ALL_PINS)
                score += spareBonus(framingRoll);
            score += rolls[framingRoll] + rolls[framingRoll + 1];
        }
        return score;
    }

    private int isSpare(int framingRoll) {
        return rolls[framingRoll] + rolls[framingRoll + 1];
    }

    private int spareBonus(int framingRoll) {
        return rolls[framingRoll + 2];
    }
}
