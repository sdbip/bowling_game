package bowling;

class Game {
    private final int[] rolls = new int[3];
    private int currentRoll = 0;

    void roll(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    int score() {
        int score = 0;
        for (int i = 0; i < rolls.length; i++)
            score += rolls[i];
        return score;
    }
}
