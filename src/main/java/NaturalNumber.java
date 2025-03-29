public class NaturalNumber {
    private final int value;

    public NaturalNumber(int value){
        if(value<1){
            throw new IllegalArgumentException(LadderError.INVALID_HEIGHT_OR_PEOPLE.getMessage());
        }
        this.value = value;
    }

    public boolean compareRow(NaturalNumber row){
        int rowValue = row.getValue();
        return rowValue >= this.value;
    }

    public boolean compareCol(NaturalNumber col){
        int colValue = col.getValue();
        return colValue >= this.value - 1;
    }


    public int getValue(){
        return value;
    }
}
