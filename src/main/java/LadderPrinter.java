public class LadderPrinter {
    public static void printLadder(Ladder ladder, LadderPosition position) {
        while (position.getX() < ladder.getNumberOfRow()) {
            System.out.println("Before");
            print(ladder, position);

            Direction dir = ladder.getDirection(position.getX(), position.getY());
            position.moveHorizontally(dir);

            System.out.println("After");
            print(ladder, position);

            position.moveDown();
        }
    }

    public static void print(Ladder ladder,LadderPosition position) {
        if (ladder == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_LADDER.getMessage());
        }
        for (int i = 0; i < ladder.getNumberOfRow(); i++) {
            try {
                Row row = ladder.getRow(i);
                LadderPosition currentPosition = (position != null && i == position.getX()) ? position : null;
                System.out.println(formatRow(row, currentPosition, i));
            } catch (Exception e) {
                if (position == null) {
                    throw new IllegalArgumentException(ErrorMessage.PRINT_ERROR.getMessage());
                }
                throw new IllegalArgumentException(ErrorMessage.NULL_ROW.getMessage() + e.getMessage());
            }
        }
        System.out.println();
    }

    public static String formatRow(Row row,LadderPosition position, int rowIndex) {
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < row.getLength(); col++) {
            sb.append(row.getDirection(col).getValue());
            if (position != null && position.matches(col)) {
                sb.append("*");
            }
            sb.append("\t");
        }
        return sb.toString();
    }
}
