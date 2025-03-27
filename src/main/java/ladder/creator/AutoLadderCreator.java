package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.RandomGenerator;
import ladder.Row;

public class AutoLadderCreator implements LadderCreator {
    private final Row[] rows;
    static final int LINE=10;
    static final double RATIO=0.3;
    static final int MAX_LINE= (int) (LINE*LINE*RATIO);

    public AutoLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        AutoDraw();
    }
    private void AutoDraw() {
        for(int i=0; i<MAX_LINE; i++){
            try{
                Position a = RandomGenerator.randomNumber(GreaterThanOne.from(LINE));
                Position b = RandomGenerator.randomNumber(GreaterThanOne.from(LINE));
                drawLine(a, b);
            }
            catch(Exception e){
                i--;
            }
        }
    }


    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

}

