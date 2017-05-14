package bowlinggame;

import java.util.ArrayList;

public class Game {

    private int score;
    private ArrayList<Frame> frames;
    private int indexFrame;

    public Game() {
        this.score = 0;
        this.indexFrame = 0;
        this.frames = new ArrayList<Frame>();
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }

    public void roll(int pinsDown){
        Frame currentFrame = frames.get(indexFrame);
        currentFrame.addRoll(pinsDown);

        if (currentFrame.isComplete()){
            indexFrame++;
        }
    }

    public int score(){
        frames.forEach((frame)->{
            score += frame.getPinsDown();
        });

        return score;
    }
}
