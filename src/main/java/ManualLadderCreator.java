public class ManualLadderCreator implements LadderCreator {

    private final LadderSize laddersize;

    public ManualLadderCreator(LadderSize laddersize) {
        this.laddersize = laddersize;
    }

    @Override
    public Ladder create() {
        return new Ladder(laddersize.getNumberOfRow(), laddersize.getNumberOfPerson());
    }

    @Override
    public void drawLine(Ladder ladder, int row, int col) {
        Index drawRow = Index.ofDrawRow(row, laddersize.getNumberOfRow());
        Index drawCol = Index.ofDrawCol(col, laddersize.getNumberOfPerson());

        Row targetRow = ladder.getRows()[drawRow.getValue()];
        Direction[] rowArray = targetRow.getRow();

        // 유효성 검사- Index
        drawCol.validateNoExistingLine(rowArray);
        drawCol.validateNoContinuousLine(rowArray);

        // 실제 선 긋기 - Row
        targetRow.drawLine(drawCol);
    }



}
