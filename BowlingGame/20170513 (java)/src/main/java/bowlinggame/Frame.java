package bowlinggame;

import java.util.ArrayList;

public class Frame {

    private int rolls;
    private int[] pinsDown;
    private int index;

    public Frame(int index) {
        this.rolls = 0;
        this.pinsDown = new int[2];
        this.index = index;
    }

    public void addRoll(int pinsDown){
        this.pinsDown[rolls] = pinsDown;
        this.rolls++;
    }

    public boolean isComplete(){
        return this.rolls == 2 || this.isStrike();
    }

    public int getPinsDown(){
        return this.pinsDown[0] + this.pinsDown[1];
    }

    public boolean isSpare(){
        return this.getPinsDown() == 10 && this.rolls == 2;
    }

    public int getFirstRoll(){
        return pinsDown[0];
    }

    public boolean isStrike(){
        return this.getPinsDown() == 10 && this.rolls == 1;
    }

    public int getSecondRoll(){
        return pinsDown[1];
    }

    public boolean isLastFrame(){
        return this.index == 9;
    }
}
