package bowlinggame;

public class Game {

    private int score;

    public Game() {
        this.score = 0;
    }

    public void roll(int pinsDown){
        score += pinsDown;
    }

    public int score(){
        return score;
    }
}
