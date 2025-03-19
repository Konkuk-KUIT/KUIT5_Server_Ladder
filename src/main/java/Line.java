import java.util.Arrays;

public class Line {
    private final Direction[][] rows;

    public Line(int numberOfRow, int numberOfPerson) {
        rows = new Direction[numberOfRow][numberOfPerson];
        for (int i = 0; i < rows.length; i++) {
            Arrays.fill(rows[i], Direction.NONE);
        }
    }

    public void drawLine(int row, int col){
        validateLine(row, col);
        rows[row][col] = Direction.RIGHT;
        rows[row][col+1] = Direction.LEFT;
    }

    public void validateLine(int row, int col){
        if(col < 0 || col >= rows[0].length-1){
            throw new ArrayIndexOutOfBoundsException("Column index out of range");
        }
        if(row < 0 || row >= rows.length){
            throw new ArrayIndexOutOfBoundsException("Row index out of range");
        }
        if(rows[row][col] != Direction.NONE || rows[row][col+1] != Direction.NONE){
            throw new IllegalArgumentException("A line already exists");
        }
    }

    public Direction getDirection(int row, int col){
        return rows[row][col];
    }

    public int getNumberOfRow(){
        return rows.length;
    }
}
