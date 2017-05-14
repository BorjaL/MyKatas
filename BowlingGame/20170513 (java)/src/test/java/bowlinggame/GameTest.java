package bowlinggame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    Game game;

    @Before
    public void initializeGame(){
        game = new Game();
    }

    @Test
    public void checksRollMethodWorks(){
        game.roll(1);

        assertEquals(game.score(), 1);
    }

    @Test
    public void checkTwoRollsInARow(){
        game.roll(2);
        game.roll(3);

        assertEquals(game.score(), 5);
    }

    @Test
    public void spareScore(){
        game.roll(5);
        game.roll(5);
        game.roll(4);

        assertEquals(game.score(), 18);
    }

    @Test
    public void strikeScore(){
        game.roll(10);
        game.roll(5);
        game.roll(4);

        assertEquals(game.score(), 28);
    }
}