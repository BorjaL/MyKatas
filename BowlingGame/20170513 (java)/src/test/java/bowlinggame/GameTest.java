package bowlinggame;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void checksRollMethodWorks(){
        Game game = new Game();

        game.roll(1);

        assertEquals(game.score(), 1);
    }

    @Test
    public void checkTwoRollsInARow(){
        Game game = new Game();

        game.roll(2);
        game.roll(3);

        assertEquals(game.score(), 5);
    }
}