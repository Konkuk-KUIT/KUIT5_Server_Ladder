/**
 * 정상 입력시 row값 초기화 확인
 * 예외 검사 작동 여부 확인
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LadderLinesTest {

    //run test

    @Test
    void run_empty_ladder_no_movement() {
        LadderLines ladderLines = new LadderLines(4, 3);

        // 아무 줄도 없는 상태 → 결과 = 입력
        assertEquals(0, ladderLines.run(0));
        assertEquals(1, ladderLines.run(1));
        assertEquals(2, ladderLines.run(2));
        assertEquals(3, ladderLines.run(3));
    }

    //줄 추가 후 이동 확인
    @Test
    void run_movement_with_line() {
        LadderLines ladderLines = new LadderLines(4, 3);

        ladderLines.drawLine(1, 1);
        assertEquals(2, ladderLines.run(1));
        assertEquals(1, ladderLines.run(2));
    }


    //시작 column 범위 확인
    @Test
    void run_invalid_start_column() {
        LadderLines ladderLines = new LadderLines(4, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            ladderLines.run(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ladderLines.run(4);
        });
    }


    @Test
    void positive_people_and_height() {
        int peopleNum = 3;
        int height = 4;
        LadderLines ladderLines = new LadderLines(peopleNum, height);
        checkHumanNum(ladderLines, peopleNum, height);
    }

    //사람 초기화 확인
    private void checkHumanNum(LadderLines ladderLines, int peopleNum, int height) {
        for (int column = 0; column < peopleNum; column++) {
            checkLine(ladderLines, column, height);
        }
    }

    //높이 초기화 확인
    private void checkLine(LadderLines ladderLines, int column, int height) {
        for (int row = 0; row < height; row++) {
            assertEquals(0, ladderLines.getRowValueAt(column, row), "row 초기화");
        }
    }

    @Test
    void people_or_height_exception() {
        // 사람 수 0
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderLines(0, 3);
        });

        // 높이 0
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderLines(3, 0);
        });

        // 사람 수, 높이 모두 음수
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderLines(-2, -5);
        });
    }

    //drewLine 기능 테스트
    @Test
    void drawLine_success() {
        int peopleNum = 4;
        int height = 3;
        LadderLines ladderLines = new LadderLines(peopleNum, height);

        // (1, 1) 위치에 줄 추가
        ladderLines.drawLine(1, 1);

        // 줄이 추가된 위치 확인
        assertEquals(1, ladderLines.getRowValueAt(1, 1));  // 오른쪽 이동
        assertEquals(-1, ladderLines.getRowValueAt(2, 1)); // 왼쪽 이동
    }

    //마지막 사다리 줄 추가 or 없는 높이 줄 추가 불가 네스트
    @Test
    void drawLine_invalid_column() {
        LadderLines ladderLines = new LadderLines(4, 3);

        // 마지막 사다리에 줄 추가 불가
        assertThrows(IllegalArgumentException.class, () -> {
            ladderLines.drawLine(3, 1);
        });
    }

    @Test
    void drawLine_invalid_row() {
        LadderLines ladderLines = new LadderLines(4, 3);

        // row가 음수
        assertThrows(IllegalArgumentException.class, () -> {
            ladderLines.drawLine(1, -1);
        });

        // row가 높이 이상
        assertThrows(IllegalArgumentException.class, () -> {
            ladderLines.drawLine(1, 3);
        });
    }



    // 연속 줄 or 이미 줄 있는 위치에 줄 추가 불가 테스트
    @Test
    void drawLine_continuous_left_line() {
        LadderLines ladderLines = new LadderLines(4, 3);

        ladderLines.drawLine(0, 1);


        assertThrows(IllegalArgumentException.class, () -> {
            ladderLines.drawLine(1, 1);
        });
    }

    @Test
    void drawLine_continuous_right_line() {
        LadderLines ladderLines = new LadderLines(4, 3);

        ladderLines.drawLine(2, 1);

        assertThrows(IllegalArgumentException.class, () -> {
            ladderLines.drawLine(1, 1);
        });
    }

    @Test
    void drawLine_duplicate_line() {
        LadderLines ladderLines = new LadderLines(4, 3);

        ladderLines.drawLine(1, 1); // 정상 추가

        // 동일 위치 줄 추가 불가
        assertThrows(IllegalArgumentException.class, () -> {
            ladderLines.drawLine(1, 1);
        });
    }





}
