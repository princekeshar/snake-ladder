/**
 * Game is 10 * 10 board. By default value is zero, if there is positive value, it will up
 */
public class SnakeLadder {

    /**
     * Represent board, numbering start from 1 to 100.
     * Board contains by default zero value, depends on ladder or snake value of board at any position changes.
     */
    private  int[ ][ ] board = new int [100][100];

    /**
     * Method accept snake head position and snake tails position.
     * Snake or ladder can't be added on same place or two ladder and snake can't be present at two place.
     *
     * @param startIndex : starting point of ladder or snake.
     * @param endIndex
     * @return
     */
    public boolean addSnakeOrLadder(int startIndex, int endIndex){

        validate(startIndex,endIndex);
        startIndex--;
        endIndex--;

       boolean snakeAdded = false;
        if( this.getBoard()[ startIndex/10][ startIndex%10 ]!=0){

            throw  new RuntimeException("Snake or ladder already present at start Index");
       }
       try{
           this.getBoard()[ startIndex/10][ startIndex%10 ] = endIndex;
           System.out.println( "Snake or Ladder at index "+ startIndex  +" with value "+endIndex);
           snakeAdded= true;
       } catch ( Exception e){
           snakeAdded= false;
           throw  new RuntimeException("Error in adding snake or ladder");
       }
        return  snakeAdded;

    }

    private void validate(int startIndex, int endIndex) {

        if( ! ( startIndex>0 && startIndex <=100 && endIndex>0 && endIndex>=100 )){
          throw new RuntimeException("Input out side of range startIndex" + startIndex + " endIndex "+endIndex );
        }
    }

    /**
     * Method accept snake head position and snake tails position.
     * Snake or ladder can't be added on same place or two ladder and snake can't be present at two place.
     *
     * @param startIndex
     * @return
     */
    public boolean removeSnakeOrLadder(int startIndex){

        boolean snakeRemoved= false;
        if( this.getBoard()[ startIndex/10][ startIndex%10 ]==0){

            throw  new RuntimeException("Snake or ladder not present");
        }
        try{
            this.getBoard()[ startIndex/10][ startIndex%10 ] = 0;
            snakeRemoved= true;
        } catch ( Exception e){
            snakeRemoved= false;
            throw  new RuntimeException("Error in adding snake or ladder");
        }
        return  snakeRemoved;

    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

}
