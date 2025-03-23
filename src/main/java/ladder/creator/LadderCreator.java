package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

// 사다리를 생성 및 선 그리기
public class LadderCreator {

    private final Row[] rows;

    // 1. 사다리 생성 틀
    public LadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        // 각 행마다, for문을 돌리면서, Node[]을 생성한다.
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    // 2. 선 그리기
    public void drawLine(Position row, Position col) {
        // 현재 위치와 다음 위치를 RIGHT/LEFT 방식으로 설정.
        rows[row.getValue()].drawLine(col);
    }

    public Row[] getRows() {
        return rows;
    }
}
