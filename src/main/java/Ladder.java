import java.util.LinkedList;
import java.util.Scanner;

public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }


    public void drawLine(Position position){

        validateDraw(position);
        this.rows[position.getRow()][position.getColumn()] = 1;

    }


    public int run(final int column){

        int result = column;

        for(int row = 0 ; row < rows.length ; row++){
           result = moveColumn(result,row);
        }

        return result;
    }


    public void validateDraw(Position position){
        position.validateRow(rows.length);
        position.validateColumn(rows[0].length);
    }

    public int moveColumn(int result, int row){

        //  길은 한 열에 한 번 씩만 이동할 수 있다.
        //  예를 들어 (0,0), (1,0), (2,0) 이런 식으로 연달아 길이 놓여진다고 해도 한 번의 길만 이동할 수 있다.
        //  좌우측에 길이 동시에 놓여져 있다면 오른쪽 길을 우선으로 간다.

        if(this.rows[row][result]==1){ // 1. 본인 열 기준에서 우측으로 길이 놓여졌을 때
            return result + 1;
        }

        if(result-1>=0 && rows[row][result - 1]==1){ // 2. 본인 열 기준에서 좌측으로 길이 놓여졌을 때
            return result - 1;
        }

        return result;
    }


}
