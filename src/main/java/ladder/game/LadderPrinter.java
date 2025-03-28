package ladder.game;

import ladder.IndexUtil;
import ladder.LadderPosition;
import ladder.Row;

public class LadderPrinter {

    public static void printLadder(Row[] rowList, LadderPosition currentPosition) {
        for (int i = 0; i < rowList.length; i++) {
            StringBuilder oneRow = rowList[i].buildLine();

            if (isCurrentRow(currentPosition, i)) {
                oneRow.insert(IndexUtil.getTokenEndIndex(oneRow, currentPosition.getY().getValue()), "*");
            }

            System.out.println(oneRow);
        }
        System.out.println();
    }

    private static boolean isCurrentRow(LadderPosition currentPosition, int rowIndex) {
        return rowIndex == currentPosition.getX().getValue();
    }
}
