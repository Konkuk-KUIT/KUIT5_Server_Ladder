/** public class Main {
    public static void main(String[] args) {
        int peopleNum = 4;
        int height = 4;
        Ladder ladder = new Ladder(peopleNum, height);

        // 사다리 줄 임의 추가
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);

        // 사다리 상태 출력
        printLadder(ladder, peopleNum, height);

        // 이동 경로 출력
        printRoute(ladder, 1, height); // column 1에서 시작
    }

    private static void printLadder(Ladder ladder, int peopleNum, int height) {
        System.out.println("----- 사다리 상태 -----");
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < peopleNum; column++) {
                int value = ladder.getRowValueAt(column, row);
                System.out.printf("%2d ", value);
            }
            System.out.println();
        }
    }

    private static void printRoute(Ladder ladder, int startColumn, int height) {
        int currentColumn = startColumn;
        System.out.println("\n----- 이동 경로 -----");
        System.out.print("시작 위치: " + currentColumn + " → ");

        for (int row = 0; row < height; row++) {
            System.out.print("(" + currentColumn + "," + row + ") ");
            int move = ladder.getRowValueAt(currentColumn, row);

            if (move == 1) {
                currentColumn++;
            } else if (move == -1) {
                currentColumn--;
            }
        }
        System.out.println("\n도착 위치: " + currentColumn);
    }
} */
