package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            printLadder("Before", i, position);
            rows[i].nextPosition(position);
            printLadder("After", i, position);
        }
        return position.getValue();
    }

    private void printLadder(String str, int i, Position position) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("\n");
        for(int j = 0; j < rows.length; j++) {
            sb.append(rows[j].printRow(printStar(i,j), position)).append("\n");
        }
        System.out.println(sb);
    }

    private boolean printStar(int i, int j){
        if(i==j)
            return true;
        return false;
    }
}
