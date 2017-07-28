package bowling;

class Game {
    private static final int ALL_PINS = 10;

    private final int[] rolls = new int[4];
    private int currentRoll = 0;

    void roll(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    int score() {
        int score = 0;
        for (int framingRoll = 0; framingRoll < rolls.length - 1; framingRoll++) {
            if (isSpare(framingRoll) == ALL_PINS)
                score += spareBonus(framingRoll);
            score += rolls[framingRoll];
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
