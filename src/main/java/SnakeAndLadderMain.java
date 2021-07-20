import javax.xml.bind.annotation.XmlType;
import java.util.Scanner;

public class SnakeAndLadderMain {

   public  static int DEFAULT_RUN = 10;

    public static void main(String[] args){





        Scanner scan = new Scanner(System.in);
        // TODO  - add logger
        System.out.println("Take number of Run");
        String numberOfRun = scan.nextLine();

        int run = DEFAULT_RUN;

        if ( ! numberOfRun.isEmpty()) {
            try{


                int num = Integer.parseInt(numberOfRun);
                run = num;
            }catch ( Exception e){
                // TODO  - add logger
                // log invalid number
                System.out.println("Invalid number of Run " + numberOfRun +  " ,taking default one "+ DEFAULT_RUN);

            }

        }

        // prepare chess board
        prepareChessBoard(scan);
        System.out.println("Board is prepared, Let's play !!");
        play(scan);


    }

    public  static void  play(Scanner scan){

    }

    public  static void  prepareChessBoard(Scanner scan){
        System.out.println("Let's Prepare Chess Board");
        SnakeLadder snakeLadder = new SnakeLadder();

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
    2. Write unit tests
3. Make the game run for 10 turns
4. Design it for a single player
5. Push the code to github and share the github repo.
6. The problem can be solved in any language.
     */

 /*   Story #3: Make A Crooked Dice

    A dice that only throws Even numbers.
    The can game can be started with normal dice or crooked
    dice.

            Story #2: Add a snake on the board

    A snake moves a player from its start position to end position
    where start position > end position
    Test data: Add a snake at position 14 moving the player
    to position 7.


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
