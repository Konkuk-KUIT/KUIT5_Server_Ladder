public class LadderCreator {

    private final int numberOfRows;
    private final int numberOfPersons;

    public LadderCreator(int numberOfRows, int numberOfPersons) {
        this.numberOfRows = numberOfRows;
        this.numberOfPersons = numberOfPersons;
    }

    public Ladder create() {
        return new Ladder(numberOfRows, numberOfPersons);
    }

    public void drawLine(Ladder ladder, int row, int col) {
        Index drawRow = Index.ofDrawRow(row, numberOfRows);
        Index drawCol = Index.ofDrawCol(col, numberOfPersons);

        Row targetRow = ladder.getRows()[drawRow.getValue()];
        Direction[] rowArray = targetRow.getRow();

        // 유효성 검사- Index
        drawCol.validateNoExistingLine(rowArray);
        drawCol.validateNoContinuousLine(rowArray);

        // 실제 선 긋기 - Row
        targetRow.drawLine(drawCol);
    }
}
