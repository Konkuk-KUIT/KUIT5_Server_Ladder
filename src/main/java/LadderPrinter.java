public class LadderPrinter {

    private final int[][] rows;

    private LadderPrinter(int[][] rows) {
        this.rows = rows;
    }

    public static LadderPrinter of(int[][] rows) {
        return new LadderPrinter(rows);
    }

    public void printWithMarker(LadderPosition position, Time time) {
        StringBuilder sb = new StringBuilder();
        sb.append(time.label()).append("\n");

        for (int i = 0; i < rows.length; i++) {
            Row row = Row.of(rows[i]);
            if (i == position.getX()) {
                row.printWithMarker(sb, position.getY());
            } else {
                row.printRow(sb);
            }
        }

        if (time == Time.AFTER) {
            sb.append("-------------------\n");
        }

        System.out.print(sb);
    }
}
