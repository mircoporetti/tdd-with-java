package me.mircoporetti.tddwithjava.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Frame> frames = new ArrayList<Frame>();

    public void roll(int pins) {
        Frame currentFrame;
        if (frames.isEmpty() || frames.get(frames.size() -1).closed) {
            currentFrame = new Frame();
            currentFrame.firstRoll = pins;
            if (currentFrame.isAStrike())
                currentFrame.closed = true;
            frames.add(currentFrame);
        }else{
            currentFrame = frames.get(frames.size() - 1);
            currentFrame.secondRoll = pins;
            currentFrame.closed = true;
        }
    }

    public int score(){
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            if (frame.isASpare()){
                score += frame.firstRoll + frame.secondRoll + frames.get(i + 1).firstRoll;
            }else{
                score += frame.firstRoll + frame.secondRoll;
            }
        }
        return score;
    }

}

