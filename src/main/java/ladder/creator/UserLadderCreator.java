package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

// 사다리 (Row객체를 담은 2차원 배열) 초기화
public class UserLadderCreator implements LadderCreator{

    private final Row[] rows;
    private final LadderSize ladderSize;

    // 1. 사다리 생성 틀
    public UserLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this(LadderSize.of(numberOfRow.getNumber(), numberOfPerson.getNumber()));
    }

    public UserLadderCreator(LadderSize size) {
        this.ladderSize = size;
        rows = new Row[size.getNumberOfRow()];
        for (int i = 0; i < size.getNumberOfRow(); i++) {
            rows[i] = new Row(GreaterThanOne.from(size.getNumberOfPerson()));
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        // 현재 위치와 다음 위치를 RIGHT/LEFT 방식으로 설정
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    @Override
    public LadderSize getLadderSize() {
        return ladderSize;
    }
}
