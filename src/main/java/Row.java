public class Row {
    private enum Direction {
        RIGHT(1),
        LEFT(-1);

        private final int value;

        Direction(int value) {
            this.value = value;
        }
    }
    private final int[] row;
    public Row(int size) {
        this.row = new int[size];
    }

    public void drawLine(NaturalNumber line) {
        validateNotOutOfBound(line);
        int index = line.getNumber() - 1;
        if(row[index] != 0 || row[index+1] != 0){
            throw new IllegalArgumentException(ExceptionMessage.INVALD_DRAW_POSITION.getMessage());
        }
        row[index] = Direction.RIGHT.value;
        row[index+1] = Direction.LEFT.value;
    }

    private void validateNotOutOfBound(NaturalNumber line) {
        if(line.getNumber() > row.length - 1){
            throw new IllegalArgumentException(ExceptionMessage.INVALD_DRAW_POSITION.getMessage());
        }
    }

    public int move(int index) {
        return index + row[index];
    }

    public String printRow(int index, boolean star) {
        StringBuilder string = new StringBuilder();
        for(int position = 0; position < row.length; position++) {
            string.append(row[position]);
            if(star && position == index){
                string.append('*');
            }
            string.append(' ');
        }
        return string.toString();
    }
}
