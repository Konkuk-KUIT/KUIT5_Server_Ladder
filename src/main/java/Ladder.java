public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    /**
     * 유효한 좌표인지 확인 후,
     * 시작 점과 끝 점이 모두 0 이여야 사다리 줄이 그어진다.
     */
    public void drawLine(int start1, int end1, int start2, int end2) {
        validatePosition(start1, end1, start2, end2);
        if (checkIfItIsZero(start1, end1, start2, end2))
        {
            rows[start1][end1] = 1;
            rows[start2][end2] = -1;
        }
    }

    /**
     * 몇 번째 사다리를 선택하면 도착하는 사다리의 번호를 알 수 있도록 구현하기.
     */
    public int run(int numOfPerson) {
        int selectedPerson = numOfPerson - 1;

        for (int i = 0; i < rows.length; i++) {
            if (rows[i][selectedPerson] == 0) {
                continue;
            }
            selectedPerson = move(i, selectedPerson);
        }

        return selectedPerson + 1;
    }

    private boolean checkIfItIsZero(int start1, int end1, int start2, int end2) {
        return rows[start1][end1] == 0 && rows[start2][end2] == 0;
    }

    private void validatePosition(int start1, int end1, int start2, int end2) {
        if (start1 < 0 || start1 >= rows.length
                || start2 < 0 || start2 >= rows.length
                || end1 < 0 || end1 >= rows[0].length
                || end2 < 0 || end2 >= rows[0].length) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다 : [start1 : " + start1 + ", end1 : " + end1 +
                    ", start2" + start2 + ", end2 : " + end2 + "\n 배열 위치에서 벗어나지 않은 숫자를 입력해주세요");
        }
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
