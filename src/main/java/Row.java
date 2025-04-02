public class Row {
    private final Node[] nodes;

    private Row(Node[] nodes) {
        this.nodes = nodes;
    }

    public static Row of(int[] rawRow) {
        Node[] nodes = new Node[rawRow.length];
        for (int i = 0; i < rawRow.length; i++) {
            nodes[i] = Node.of(rawRow[i]);
        }
        return new Row(nodes);
    }

    public void printWithMarker(StringBuilder sb, int yMarker) {
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i]);
            if (i == yMarker) {
                sb.append("*");
            }
            if (i < nodes.length - 1) sb.append(" ");
        }
        sb.append("\n");
    }

    public void printRow(StringBuilder sb) {
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i]);
            if (i < nodes.length - 1) sb.append(" ");
        }
        sb.append("\n");
    }
}
