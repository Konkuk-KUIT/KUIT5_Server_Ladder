package ladder;

public class Ladder {

    private final Row[] rows;

    public Ladder(LadderSize size) {
        rows = new Row[size.getNumberOfRow()];
        for (int i = 0; i < size.getNumberOfRow(); i++) {
            rows[i] = new Row(size.getNumberOfPerson());
        }
    }

    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public int run(int position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            printState(position,i);
            position = rows[i].nextPosition(position);
            System.out.println("After");
            printState(position,i);
        }
        return position;
    }

    private void printState(int position,int row){
        for(int i=0; i<rows.length; i++){
            for(int j=0;j<rows[i].getRow().length;j++){
                System.out.print(rows[i].getRow()[j]);
                // 해당 위치에 * 출력
                printStar(position, row, i, j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void printStar(int position, int row, int i, int j) {
        if(i == row && j == position){
            System.out.print("*");
        }
    }

    public Row[] getRows() {
        return rows;
    }
}
