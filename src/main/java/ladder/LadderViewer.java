package ladder;

public class LadderViewer {

    private static final String BEFORE = "Before\n";
    private static final String AFTER = "After\n";

    private final Row[] rows;
    private int printCount;

    public LadderViewer(Row[] rows) {
        this.rows = rows;
    }

    public void printLadderStatus(LadderPosition ladderPosition) {
        String generate = generate(ladderPosition);
        System.out.println(generate);
    }

    private String generate(LadderPosition ladderPosition) {
        StringBuilder sb = new StringBuilder();
        appendLabel(sb);
        for (int i = 0; i < rows.length; i++) {
            rows[i].generateRow(sb, Position.from(i), ladderPosition);
        }
        return sb.toString();
    }

    private void appendLabel(StringBuilder sb) {
        printCount++;
        if (printCount % 2 != 0) {
            sb.append(BEFORE);
            return;
        }
        sb.append(AFTER);
    }
}