package bowlinggame;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrameTest {

    @Test
    public void checkAddRollWorks() {
        Frame frame = new Frame();
        frame.addRoll(5);
        assertEquals(frame.getPinsDown(), 5);
    }

    @Test
    public void checkTwoRollsInARow() throws Exception {
        Frame frame = new Frame();
        frame.addRoll(5);
        frame.addRoll(1);
        assertEquals(frame.getPinsDown(), 6);
    }

    @Test
    public void isComplete() throws Exception {
        Frame frame = new Frame();
        frame.addRoll(5);
        frame.addRoll(1);
        assertEquals(frame.isComplete(), true);
    }

    @Test
    public void isSpare() throws Exception {
        Frame frame = new Frame();
        frame.addRoll(4);
        frame.addRoll(6);
        assertEquals(frame.isSpare(), true);
    }

    @Test
    public void getFirstRoll() throws Exception {
        Frame frame = new Frame();
        frame.addRoll(4);
        frame.addRoll(6);
        assertEquals(frame.getFirstRoll(), 4);
    }

}