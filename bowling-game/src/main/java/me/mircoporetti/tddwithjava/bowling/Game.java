package me.mircoporetti.tddwithjava.bowling;

public class Game {

    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        this.rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(rollIndex))
                score += 10 + rolls[rollIndex + 2];
            else
                score += rolls[rollIndex] + rolls[rollIndex + 1];
            rollIndex += 2;
        }
        return score;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
}
