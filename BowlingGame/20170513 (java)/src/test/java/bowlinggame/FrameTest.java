package bowlinggame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FrameTest {

    Frame frame;

    @Before
    public void initializeGame(){
        frame = new Frame(1);
    }

    @Test
    public void checkAddRollWorks() {
        frame.addRoll(5);
        assertEquals(frame.getPinsDown(), 5);
    }

    @Test
    public void checkTwoRollsInARow() throws Exception {
        frame.addRoll(5);
        frame.addRoll(1);
        assertEquals(frame.getPinsDown(), 6);
    }

    @Test
    public void isComplete() throws Exception {
        frame.addRoll(5);
        frame.addRoll(1);
        assertEquals(frame.isComplete(), true);
    }

    @Test
    public void isSpare() throws Exception {
        frame.addRoll(4);
        frame.addRoll(6);
        assertEquals(frame.isSpare(), true);
    }

    @Test
    public void getFirstRoll() throws Exception {
        frame.addRoll(4);
        frame.addRoll(6);
        assertEquals(frame.getFirstRoll(), 4);
    }

    @Test
    public void isStrike() throws Exception {
        frame.addRoll(10);
        assertEquals(frame.isStrike(), true);
    }

    @Test
    public void isCompleteSpare() throws Exception {
        frame.addRoll(5);
        frame.addRoll(5);
        assertEquals(frame.isComplete(), true);
    }

    @Test
    public void isCompleteStrike() throws Exception {
        frame.addRoll(10);
        assertEquals(frame.isComplete(), true);
    }

    @Test
    public void getSecondRoll() throws Exception {
        frame.addRoll(1);
        frame.addRoll(5);
        assertEquals(frame.getSecondRoll(), 5);
    }

    @Test
    public void isLastFrame() throws Exception {
        frame = new Frame(9);
        assertEquals(frame.isLastFrame(), true);
    }
}