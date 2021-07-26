package dice;

public class CrookedDice implements  Dice {

    public int throwAndGetValue() {

        return  2 *  (  ((int) (Math.random() * 3)) +1 ) ;
    }
}
