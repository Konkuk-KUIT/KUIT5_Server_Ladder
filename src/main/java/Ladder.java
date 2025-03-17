public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(int start1, int end1, int start2, int end2) {
        if (rows[start1][end1] == 0) {
            rows[start1][end1] = 1;
            rows[start2][end2] = -1;
        }
    }
    //run : 몇 번째 사다리를 선택하면 도착하는 사다리의 번호를 알 수 있도록 구현하기.
    //

    public int run(int numOfPerson) {
        int selectedPerson = numOfPerson - 1;

        for (int i = 0; i < rows.length; i++) {
            if (rows[i][selectedPerson] == 0) {
                continue;
            }
//            if (rows[i][selectedPerson] == 1) {
//                selectedPerson += 1;
//            }
//            if (rows[i][selectedPerson] == -1) {
//                selectedPerson -= 1;
//            }
            selectedPerson = move(i, selectedPerson);
        }

        return selectedPerson + 1;
    }

    private int move(int row, int selectedPerson) {
        if (rows[row][selectedPerson] == 1) {
            return selectedPerson += 1;
        }
        if (rows[row][selectedPerson] == -1) {
            return selectedPerson -= 1;
        }
        return selectedPerson;
    }

    public void printLadder() {
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length; j++) {
                System.out.print(rows[i][j] + " ");
            }
            System.out.println();
        }
    }
}
