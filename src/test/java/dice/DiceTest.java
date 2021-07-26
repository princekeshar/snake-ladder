package dice;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    //for normal addition
    @Test
    public void testNormalDice()
    {
        Dice dice = new NormalDice();
        int [ ] ar = new int [10];
        for(int i : ar){
            int value = dice.throwAndGetValue();
            System.out.println("Normal dice value  "+value);

            assertTrue( value <=6 && value >=1 );

        }
    }

    @Test
    public void testCrooked()
    {
        Dice dice = new CrookedDice();
        int [ ] ar = new int [10];
        for(int i : ar){
            int value = dice.throwAndGetValue();
            System.out.println("Crooked dice value  "+value);
            assertTrue( value  <=6 && value  >=1 && value%2==0 );
        }
    }

}
