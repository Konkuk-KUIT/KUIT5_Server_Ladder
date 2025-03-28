package ladder;

import ladder.position.LadderPosition;
import ladder.position.Position;

public class LadderPainter {




    public void printLadder(String prefix, LadderPosition ladderPosition, Row[] rows) {
        System.out.println(prefix + ladderToString(ladderPosition,rows));
    }


    public void printLadderStructure(Row[] rows){
        StringBuilder sb = new StringBuilder();
        for (Row row : rows) {
            sb.append(row.nodeToString());
            sb.append("\n");
        }
        System.out.println(sb);
    }


    private String ladderToString(LadderPosition ladderPosition, Row[] rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            sb.append(rows[i].nodeToString(i, ladderPosition));
            sb.append("\n");
        }
        return sb.toString();
    }


}
