package me.mircoporetti.tddwithjava.bowling.game;

import me.mircoporetti.tddwithjava.bowling.exception.TooManyGamesException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int MAX_FRAMES = 10;
    private int score = 0;

    private final List<Frame> frames = new ArrayList<>();

    public void roll(int pins) {
        if(moreRollsAvailable()) {
            if (isTheFirstFrameOrIsThePreviousClosed()) {
                rollInNewFrame(pins);
            } else {
                rollInExistingFrame(pins);
            }
        }else{
            throw new TooManyGamesException("Ehi man too many rolls, the game is finished!");
        }
    }

    private boolean moreRollsAvailable() {
        return frames.size() < MAX_FRAMES || (frames.size() == 10 && !frames.get(frames.size() - 1).closed);
    }

    private boolean isTheFirstFrameOrIsThePreviousClosed() {
        return frames.isEmpty() || frames.get(frames.size() - 1).closed;
    }

    private void rollInNewFrame(int pins) {
        Frame currentFrame;
        currentFrame = buildFrame();
        currentFrame.firstRoll = pins;
        if (currentFrame.isAStrike())
            closeFrameIfNotLast(currentFrame);
        frames.add(currentFrame);
    }

    private Frame buildFrame() {
        Frame currentFrame;
        if(frames.size() == MAX_FRAMES - 1){
            currentFrame = new LastFrame();
        }else{
            currentFrame = new Frame();
        }
        return currentFrame;
    }

    private void closeFrameIfNotLast(Frame currentFrame) {
        if (!isTheLastFrame(currentFrame)) {
            currentFrame.closed = true;
        }
    }

    private void rollInExistingFrame(int pins) {
        Frame currentFrame = frames.get(frames.size() - 1);
        if (isTheLastFrame(currentFrame)){
            if(((LastFrame) currentFrame).extraRollAvailable) {
                ((LastFrame) currentFrame).thirdRoll = pins;
                currentFrame.closed = true;
            }else{
                currentFrame.secondRoll = pins;
                if(currentFrame.isASpare() || currentFrame.isAStrike())
                    ((LastFrame) currentFrame).extraRollAvailable = true;
                else currentFrame.closed = true;
            }
        }else{
            currentFrame.secondRoll = pins;
            currentFrame.closed = true;
        }
    }

    public int score(){
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            if(!(isTheLastFrame(frame))) {
                scoreRegularFrame(i, frame);
            }else{
                scoreLastFrame(frame);
            }
        }
        return score;
    }

    private void scoreRegularFrame(int currentFrameIndex, Frame frame) {
        if (frame.isASpare()) {
            Frame nextFrame = frames.get(currentFrameIndex + 1);
            score += frame.firstRoll + frame.secondRoll + nextFrame.firstRoll;
        } else if (frame.isAStrike()) {
            Frame nextFrame = frames.get(currentFrameIndex + 1);
            score += frame.firstRoll + nextFrame.firstRoll;
            if (isAStrikeAndNotTheLastFrame(nextFrame)){
                Frame nextTwo = frames.get(currentFrameIndex + 2);
                score += nextTwo.firstRoll;
            }else{
                score += nextFrame.secondRoll;
            }
        } else {
            score += frame.firstRoll + frame.secondRoll;
        }
    }

    private boolean isAStrikeAndNotTheLastFrame(Frame frame) {
        return frame.firstRoll == 10 && !(isTheLastFrame(frame));
    }

    private boolean isTheLastFrame(Frame currentFrame) {
        return currentFrame instanceof LastFrame;
    }

    private void scoreLastFrame(Frame frame) {
        score += frame.firstRoll + frame.secondRoll + ((LastFrame) frame).thirdRoll;
    }
}

