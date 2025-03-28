import java.util.List;

public class Ladder {

    private final Row[] rows;

    public Ladder(int row, int numberOfPerson){
        rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public int run(int selectcol) {
        Index selcol = Index.ofSelectCol(selectcol, rows[0].getRow().length);

        LadderPosition currentposition;
        for (int i=0; i< rows.length; i++) {
            System.out.println("Before");
            currentposition = new LadderPosition(selcol.getValue(),i);
            System.out.println(PrintLadder(currentposition));

            selcol = rows[i].moveLadder(selcol);

            System.out.println("After");
            currentposition = new LadderPosition(selcol.getValue(),i);
            System.out.println(PrintLadder(currentposition));

        }
        return selcol.getValue()+1;
    }

    public Row[] getRows() {
        return rows;
    }

    public StringBuilder PrintLadder(LadderPosition currentposition) {
        StringBuilder sb = new StringBuilder();
        int currentY = currentposition.getY();
        for (int i=0; i<rows.length; i++) {
            int currentX = -1;
            if (currentY==i) {
                currentX = currentposition.getX();
            }
            sb.append(rows[i].PrintRow(currentX));

        }
        return sb;
    }


}
