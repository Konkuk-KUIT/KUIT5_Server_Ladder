package ladder.core;

import ladder.utils.GreaterThanOne;

public class LadderSize {
    private GreaterThanOne row;
    private GreaterThanOne col;

    private LadderSize(GreaterThanOne row, GreaterThanOne col) {
        this.row = row;
        this.col = col;
    }

    public static LadderSize of(GreaterThanOne row, GreaterThanOne col) {
        return new LadderSize(row, col);
    }

    public GreaterThanOne getRow() {
        return row;
    }

    public GreaterThanOne getCol() {
        return col;
    }

    public int getSize() {
        return getRow().getNumber() * getCol().getNumber();
    }
}
