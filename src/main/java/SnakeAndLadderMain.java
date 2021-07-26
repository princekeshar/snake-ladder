import dice.CrookedDice;
import dice.Dice;
import dice.NormalDice;

import java.util.Scanner;

public class SnakeAndLadderMain {

   public  static int DEFAULT_RUN = 10;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        SnakeLadder snakeLadder = new SnakeLadder();
        // prepare chess board
        prepareBoard(scan,snakeLadder);
        // Choose Dice
        Dice dice = chooseDice(scan);
        System.out.println("Board is prepared, Let's play !!");
        play(scan, DEFAULT_RUN, snakeLadder, dice);
    }


    public  static  Dice chooseDice(Scanner scan){
        Dice dice = null;
        while (true){
            System.out.println("Please choose Dice:  \n 1. Normal Dice - Gives output from 1 to 6. \n 2. Crooked Dice - gives output even number upto 6.");
            int expression = scan.nextInt();
            if( expression==1 || expression==2){
                dice =  expression==1 ? new NormalDice() : new CrookedDice();
                break;
            }
        }
        return  dice;
    }

    /**
     * Player will win the game if he reaches at 100. In code terms, it will be 99, as player is starting from -1.
     * @param scan        scan element
     * @param numberOfRun number of dice will be rolled
     * @param snakeLadder snake ladder object.
     * @param dice        type of dice
     */
    public  static void  play(Scanner scan, int numberOfRun, SnakeLadder snakeLadder, Dice dice){

        int currentLocation = 0;
        while (numberOfRun >0 || currentLocation <100){
            System.out.println("Game will run "+ numberOfRun +" of times");
            System.out.println("Press any key and enter to roll dice");
            String line = scan.nextLine();
            int value = dice.throwAndGetValue();
            System.out.println("Dice value is "+ value );

            System.out.println("Previous location is "+ currentLocation  );

            if( currentLocation+value<100 ){
                currentLocation +=value;
                currentLocation = getUpdatedValue(currentLocation, snakeLadder);
            }

            if( currentLocation==100 ){
                System.out.println( "Congrat's you have won, you have reached 100. Terminating Game");
                break;
            }

            System.out.println( "Updated value of nth Run is "+ currentLocation);
            numberOfRun--;
        }
        if(numberOfRun==0){
            System.out.println("Number of chances is over");
        }
    }

    /**
     * Function to update current location if there is snake or ladder.
     */
    public  static  int getUpdatedValue(int index, SnakeLadder snakeLadder){
        int row = index/10 -1;
        int col = index%10 - 1;
        if(col<0){
            col = 9;
        }
        if(row<0){
            row = 0;
        }
        if ( snakeLadder.getBoard()[row][col] ==0 || index ==100){
            return  index;
        }
       return getUpdatedValue ( snakeLadder.getBoard()[row][col] , snakeLadder);
    }


    public  static void  prepareBoard(Scanner scan, SnakeLadder snakeLadder){
        System.out.println("Let's Prepare Snake Board");
        while (true){
            System.out.println("Please give required input:  \n 1. Add Snake or Ladder \n 2. Done with board preparation");
            int expression = scan.nextInt();
            if( expression==2){
                break;
            }
            switch(expression)
            {
                case 1 :
                    System.out.println( "Please input start Index");
                    int startIndex = scan.nextInt();
                    System.out.println( "Please input end Index");
                    int addIndex = scan.nextInt();
                    snakeLadder.addSnakeOrLadder(startIndex,addIndex);
                    break;
                default :
                    continue;
            }
        }
    }

}
