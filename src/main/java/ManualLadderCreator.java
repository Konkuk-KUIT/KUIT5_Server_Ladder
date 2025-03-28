public class ManualLadderCreator implements LadderCreator {

    private final LadderSize laddersize;
    private final Row[] rows;

    public ManualLadderCreator(LadderSize laddersize) {
        this.laddersize = laddersize;
        this.rows = createRows();
    }

    private Row[] createRows() {
        Row[] result = new Row[laddersize.getNumberOfRow()];
        for (int i = 0; i < laddersize.getNumberOfRow(); i++) {
            result[i] = new Row(laddersize.getNumberOfPerson());
        }
        return result;
    }

    @Override
    public void drawLine(int row, int col) {
        Index drawRow = Index.ofDrawRow(row, laddersize.getNumberOfRow());
        Index drawCol = Index.ofDrawCol(col, laddersize.getNumberOfPerson());

        Row targetRow = rows[drawRow.getValue()];
        Direction[] rowArray = targetRow.getRow();

        // 유효성 검사- Index
        drawCol.validateNoExistingLine(rowArray);
        drawCol.validateNoContinuousLine(rowArray);

        // 실제 선 긋기 - Row
        targetRow.drawLine(drawCol);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }




}
