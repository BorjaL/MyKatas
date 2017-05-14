package bowlinggame;

import java.util.ArrayList;

public class Frame {

    private int rolls;
    private int pinsDown;

    public Frame() {
        this.rolls = 0;
        this.pinsDown = 0;
    }

    public void addRoll(int pinsDown){
        this.pinsDown += pinsDown;
        this.rolls++;
    }

    public boolean isComplete(){
        return this.rolls == 2;
    }

    public int getPinsDown(){
        return this.pinsDown;
    }
}
