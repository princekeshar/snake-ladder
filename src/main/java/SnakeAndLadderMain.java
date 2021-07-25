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
        prepareChessBoard(scan,snakeLadder);
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
     * Player will win the game if he reaches at 100.
     * He has to reach 100, he can't move to position 101 i.e. if player is at 99, to win the game he need to get 1.
     * @param scan
     * @param numberOfRun
     * @param snakeLadder
     * @param dice
     */
    public  static void  play(Scanner scan, int numberOfRun, SnakeLadder snakeLadder, Dice dice){

        int currentLocation = 0;
        while (numberOfRun >0 || currentLocation ==100){
            System.out.println("Game will run "+ numberOfRun +" of times");
            System.out.println("Press any key and enter to roll dice");
            String line = scan.nextLine();
            int value = dice.throwAndGetValue();
            System.out.println("Dice value is "+ value );

            System.out.println("Previous location is "+ currentLocation  );

            if(currentLocation+value<100){
                currentLocation +=value;
                currentLocation = getUpdatedValue(currentLocation, snakeLadder);
            }

            if(currentLocation+value==100){
                System.out.println( "Congrat's you have won, you have reached 100");
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
    public  static  int getUpdatedValue(int currentLocation, SnakeLadder snakeLadder){
        int index = currentLocation -1;
        if ( snakeLadder.getBoard()[index/10][index%10] ==0 || index ==99){
            return  currentLocation;
        }
       return getUpdatedValue ( snakeLadder.getBoard()[index/10][index%10] , snakeLadder);
    }

    public  static void  prepareChessBoard(Scanner scan, SnakeLadder snakeLadder){
        System.out.println("Let's Prepare Chess Board");
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

 /*
    Story #1: Basic Board
    On a board (Of size 100), for a dice throw a player should
    move from initial position by the number on dice throw
    Make small commits
2. Write unit tests
3. Make the game run for 10 turns
4. Design it for a single player
5. Push the code to github and share the github repo.
            6. The problem can be solved in any language. */
}
