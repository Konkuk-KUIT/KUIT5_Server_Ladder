package ladder;

import java.lang.reflect.Array;

public class LadderSize {
    private int numberOfRow;
    private int numberOfPerson;
    private int [][] drawPoint;

    public LadderSize(int numberOfRow, int numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
        drawPoint = new int[numberOfRow][numberOfPerson-1];
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getLineNum() {
        return (int) (numberOfRow * numberOfPerson * 0.3);
    }

    public int[][] getDrawPoint() {
        return drawPoint;
    }

    public void setDrawPoint(int row, int col) {
        drawPoint[row][col]=1;
    }
}
