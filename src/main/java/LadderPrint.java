public class LadderPrint {
    public static StringBuilder PrintLadder(Row[] rows, LadderPosition currentposition) {
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
