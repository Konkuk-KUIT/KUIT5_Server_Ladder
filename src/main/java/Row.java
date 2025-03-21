public class Row {

    private final LineValue[] lineStates;

    public Row(int numberOfPerson) {
        this.lineStates = new LineValue[numberOfPerson];
        for (int i = 0; i < lineStates.length; i++) {
            lineStates[i] = LineValue.NONE;
        }
    }

    public void drawLine(int y) {
        if (!isValidPosition(y)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }

        if (!canDrawLineAt(y)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LINE.getMessage());
        }

        lineStates[y] = LineValue.RIGHT;
        lineStates[y + 1] = LineValue.LEFT;
    }

    private boolean isValidPosition(int y) { // 범위 확인
        return y >= 0 && y < lineStates.length - 1;
    }

    private boolean canDrawLineAt(int y) { // 중복 확인
        return (lineStates[y] == LineValue.NONE) && (lineStates[y + 1] == LineValue.NONE);
    }

    public LineValue[] getLineStates() {
        return lineStates;
    }
}
