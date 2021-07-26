
import dice.CrookedDice;
import dice.Dice;
import dice.NormalDice;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class SnakeAndLadderMainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }


    @Test
    public   void testNormalDice()
    {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Dice dice = SnakeAndLadderMain.chooseDice(new Scanner(System.in));
        assertEquals(dice.getClass(), NormalDice.class);
        ByteArrayInputStream in2 = new ByteArrayInputStream("2".getBytes());
        System.setIn(in2);
        dice = SnakeAndLadderMain.chooseDice(new Scanner(System.in));
        assertEquals(dice.getClass(), CrookedDice.class);

    }
}
