import java.util.Arrays;

public class Ladder {

    private final int[][] rows;

    public int[][] getRows() {
        return rows;
    }

    public Ladder(int row, int numberOfPerson) {
        if (row < 1 || numberOfPerson < 1) {
            throw new IllegalArgumentException("invalid number");
        }
        this.rows = new int[row][numberOfPerson];
    }

    public void init() {
        for (int i = 0; i < rows.length; i++) {
            Arrays.fill(rows[i], 0);
        }
    }

    public void drawLine(Position position) {
        position.checkLine(rows);
        rows[position.getX()][position.getY()] = 1;
        rows[position.getX()][position.getY() + 1] = -1;
    }

    public int run(int ladderNum) {
        int result = ladderNum - 1;

        for (int i = 0; i < rows.length; i++) {
            result += rows[i][result];
        }
        return result + 1;
    }

}