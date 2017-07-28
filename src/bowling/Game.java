package bowling;

class Game {
    private final int[] rolls = new int[4];
    private int currentRoll = 0;

    void roll(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    int score() {
        int score = 0;
        for (int i = 0; i < rolls.length - 1; i++) {
            if (rolls[i] + rolls[i + 1] == 10) // spare
                score += rolls[i + 2];
            score += rolls[i];
        }
        return score;
    }
}
