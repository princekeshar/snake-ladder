import dice.Dice;
import dice.NormalDice;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SnakeLadderTest {


    @Test
    public void testSnakeLadderSize()
    {
        SnakeLadder snakeLadder = new SnakeLadder() ;


        assertEquals(snakeLadder.getBoard().length , 10);
        assertEquals(snakeLadder.getBoard()[0].length , 10);

    }

    @Test
    public void testAddRemoveSnakeLadder()
    {
        SnakeLadder snakeLadder = new SnakeLadder();
        boolean value = snakeLadder.addSnakeOrLadder(1, 11);
        assertTrue(value);
        assertEquals(snakeLadder.getBoard()[0][0], 11);
        snakeLadder.removeSnakeOrLadder(1);
        assertEquals(snakeLadder.getBoard()[0][0], 0);
    }




}
