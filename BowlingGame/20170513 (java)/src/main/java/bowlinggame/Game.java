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
            frames.add(new Frame(i));
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
        for (int i = 0; i < frames.size(); i++){
            Frame frame = frames.get(i);
            score += frame.getPinsDown();

            if (frame.isSpare()) {
                score += frames.get(i + 1).getFirstRoll();
            }
            else if (frame.isStrike()){
                if (frames.get(i+1).isStrike()){
                    score += frames.get(i+1).getFirstRoll() + frames.get(i+2).getFirstRoll();
                }
                else {
                    score += frames.get(i+1).getFirstRoll() + frames.get(i+1).getSecondRoll();
                }
            }
        }

        return score;
    }
}
