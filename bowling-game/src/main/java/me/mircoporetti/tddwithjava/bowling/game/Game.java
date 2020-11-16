package me.mircoporetti.tddwithjava.bowling.game;

import me.mircoporetti.tddwithjava.bowling.exception.TooManyGamesException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int maxFrames = 10;

    private final List<Frame> frames = new ArrayList<Frame>();

    public void roll(int pins) {
        Frame currentFrame;
        if(noMoreFramesAvailable()) {
            if (isTheFirstFrameOrIsThePreviousClosed()) {
                currentFrame = new Frame();
                currentFrame.firstRoll = pins;
                if (currentFrame.isAStrike())
                    currentFrame.closed = true;
                frames.add(currentFrame);
            } else {
                currentFrame = frames.get(frames.size() - 1);
                currentFrame.secondRoll = pins;
                currentFrame.closed = true;
            }
        }else{
            throw new TooManyGamesException("Ehi man too many rolls, the game is finished!");
        }
    }

    public int score(){
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            if (frame.isASpare()){
                score += frame.firstRoll + frame.secondRoll + frames.get(i + 1).firstRoll;
            }else if (frame.isAStrike()){
                score += frame.firstRoll + frames.get(i + 1).firstRoll + frames.get(i + 1).secondRoll;
            }else{
                score += frame.firstRoll + frame.secondRoll;
            }
        }
        return score;
    }

    private boolean noMoreFramesAvailable() {
        return frames.size() < maxFrames || (frames.size() == 10 && !frames.get(frames.size() - 1).closed);
    }

    private boolean isTheFirstFrameOrIsThePreviousClosed() {
        return frames.isEmpty() || frames.get(frames.size() - 1).closed;
    }
}

