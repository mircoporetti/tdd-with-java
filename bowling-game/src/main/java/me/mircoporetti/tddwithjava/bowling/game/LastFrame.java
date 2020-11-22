package me.mircoporetti.tddwithjava.bowling.game;

public class LastFrame extends Frame {

    public int thirdRoll;
    public boolean extraRollAvailable;

    public boolean isAStrike() {
        return firstRoll == 10 || secondRoll == 10;
    }
}
