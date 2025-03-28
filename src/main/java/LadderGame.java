public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;  // 외부에서 주입된 전략 사용
    }

    public int run(int selectcol) {
        Row[] rows = ladderCreator.getRows();
        Index selcol = Index.ofSelectCol(selectcol, rows[0].getRow().length);

        LadderPosition currentposition;
        for (int i=0; i< rows.length; i++) {
            System.out.println("Before");
            currentposition = new LadderPosition(selcol.getValue(),i);
            System.out.println(LadderPrint.PrintLadder(rows,currentposition));

            selcol = rows[i].moveLadder(selcol);

            System.out.println("After");
            currentposition = new LadderPosition(selcol.getValue(),i);
            System.out.println(LadderPrint.PrintLadder(rows,currentposition));

        }
        return selcol.getValue()+1;
    }
}
