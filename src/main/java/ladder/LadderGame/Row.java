package ladder.LadderGame;

import static ladder.LadderGame.Direction.*;
import static ladder.exception.ExceptionMessage.INVALID_DRAW_POSITION;
import static ladder.exception.ExceptionMessage.INVALID_POSITION;

public class Row {

    private final int[] row;

    private Row(Positive numberOfMember){
        row = new int[numberOfMember.getNumber()+1];
    }

    public static Row of(Positive numberOfMember){
        return new Row(numberOfMember);
    }

    public void drawLine(int position){

        validateDrawPosition(position);
        row[position] = RIGHT.getValue();
        row[position+1] = LEFT.getValue();
    }

    public int move(int nowPosition){

        validateMovePosition(nowPosition);

        if(row[nowPosition] == RIGHT.getValue()){
            return RIGHT.getValue();
        }

        if(row[nowPosition] == LEFT.getValue()){
            return LEFT.getValue();
        }

        return STAY.getValue();

    }



    public void printRowWithOutCurrentPosition(int nowLine){
        for (int i = 1; i < row.length; i++) {
            System.out.print(row[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public void printRowWithCurrentPosition(int nowLine){
        for (int i = 1; i < row.length; i++) {
            System.out.print(row[i]);
            if(nowLine == i){
                System.out.print("*");
            }
            System.out.print(" ");
        }
        System.out.print("\n");
    }


    private void validateDrawPosition(int position){
        if(position < 1 || row.length-2 < position){
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }

        if(row[position] != 0 || row[position+1] != 0){
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private void validateMovePosition(int position){
        if(position < 1 || row.length-1 < position){
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

}
