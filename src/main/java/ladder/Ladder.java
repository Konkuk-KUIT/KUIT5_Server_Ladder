package ladder;

// 전체 사다리 클래스
public class Ladder {

    private final LadderLines ladderLines;
    private final int height;

    // 사다리 생성
    public Ladder(LadderSize size) {
        this.ladderLines = new LadderLines(size);
        this.height = size.getNumberOfRow();
    }

    // 사다리에 줄 긋기
    public void drawLine(int x, int y) {
        ladderLines.drawLine(x, y);
    }

    // 사다리 이동(현재 위치 커서)
    public int run(int startCol) {
        LadderPosition cursor = new LadderPosition(startCol, 0);

        for (int i = 0; i < height; i++) {
            print(cursor, ">>>>>>>>>>>>>>>>>>>>> BEFORE"); // 이동 전
            cursor = move(cursor);                         // 이동
            print(cursor, ">>>>>>>>>>>>>>>>>>>>> AFTER");  // 이동 후
            cursor = cursor.down();                        // 아래로
        }

        // 최종 위치
        return cursor.getX();
    }

    // move 분리
    private LadderPosition move(LadderPosition cursor) {
        int move = ladderLines.getRowVal(cursor.getX(), cursor.getY());
        if (move == Direction.RIGHT.getValue()) {
            return cursor.right();
        }
        if (move == Direction.LEFT.getValue()) {
            return cursor.left();
        }
        return cursor;
    }

    // 사다리 상태 출력
    private void print(LadderPosition cursor, String title) {
        System.out.println(title);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < ladderLines.getNumberOfPerson(); x++) {
                System.out.print(" " + ladderLines.draw(x, y, cursor) + " ");
            }
            System.out.println();
        }
    }
}

