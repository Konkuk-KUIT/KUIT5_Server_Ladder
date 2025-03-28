public class Row {
    private final int[] rows;

    private Row(int[] rows) {
        this.rows = rows;
    }

    public static Row of(int[] rows) {
        return new Row(rows);
    }

    public void printWithMarker(StringBuilder sb, int yMarker) {
        for (int i = 0; i < rows.length; i++) {
            sb.append(rows[i]);
            if (i == yMarker) {
                sb.append("*");
            }
            if (i < rows.length - 1) sb.append(" ");
        }
        sb.append("\n");
    }

    public void printRow(StringBuilder sb) {
        for (int i = 0; i < rows.length; i++) {
            sb.append(rows[i]);
            if (i < rows.length - 1) sb.append(" ");
        }
        sb.append("\n");
    }
}
