package bowling;

class Game {

    private int score = 0;

    int score() {
        return score;
    }

    void roll(int pins) {
        score = pins;
    }
}
