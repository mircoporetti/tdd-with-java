package me.mircoporetti.tddwithjava.bowling.game;

import me.mircoporetti.tddwithjava.bowling.exception.TooManyGamesException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int maxFrames = 10;

    private final List<Frame> frames = new ArrayList<>();

    public void roll(int pins) {
        Frame currentFrame;
        if(moreFramesAvailable()) {
            if (isTheFirstFrameOrIsThePreviousClosed()) {
                if(frames.size() == 9){
                    currentFrame = new LastFrame();
                }else{
                    currentFrame = new Frame();
                }
                currentFrame.firstRoll = pins;
                if (currentFrame.isAStrike())
                    if (!(currentFrame instanceof LastFrame)) {
                        currentFrame.closed = true;
                    }
                frames.add(currentFrame);
            } else {
                currentFrame = frames.get(frames.size() - 1);
                if (currentFrame instanceof LastFrame){
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
        }else{
            throw new TooManyGamesException("Ehi man too many rolls, the game is finished!");
        }
    }

    public int score(){
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            if(!(frame instanceof LastFrame)) {
                if (frame.isASpare()) {
                    score += frame.firstRoll + frame.secondRoll + frames.get(i + 1).firstRoll;
                } else if (frame.isAStrike()) {
                    score += frame.firstRoll + frames.get(i + 1).firstRoll;
                    if (frames.get(i + 1).firstRoll == 10 && !(frames.get(i + 1) instanceof LastFrame)){
                        score += frames.get(i + 2).firstRoll;
                    }else{
                        score += frames.get(i + 1).secondRoll;
                    }
                } else {
                    score += frame.firstRoll + frame.secondRoll;
                }
            }else{
                score += frame.firstRoll + frame.secondRoll + ((LastFrame) frame).thirdRoll;
            }
        }
        return score;
    }

    private boolean moreFramesAvailable() {
        return frames.size() < maxFrames || (frames.size() == 10 && !frames.get(frames.size() - 1).closed);
    }

    private boolean isTheFirstFrameOrIsThePreviousClosed() {
        return frames.isEmpty() || frames.get(frames.size() - 1).closed;
    }
}

