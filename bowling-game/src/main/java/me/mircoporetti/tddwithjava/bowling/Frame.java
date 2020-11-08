package me.mircoporetti.tddwithjava.bowling;

public class Frame {

    public int firstRoll;
    public int secondRoll;
    public boolean closed;


    public boolean isASpare() {
        return !isAStrike() && (firstRoll + secondRoll == 10);
    }

    public boolean isAStrike() {
        return firstRoll == 10;
    }
}
