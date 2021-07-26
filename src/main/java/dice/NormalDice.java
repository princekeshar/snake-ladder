package dice;

public class NormalDice implements  Dice {

    /**
     * Normal dice randomly throw a number between 1 to 6;
     * @return
     */
    public int throwAndGetValue() {

        return  ( (int) (Math.random() * 6 )) +1;

    }
}
