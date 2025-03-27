package ladder.creator;

import ladder.*;

import static ladder.AutoLine.LINE;
import static ladder.AutoLine.RATIO;

public class AutoLadderCreator implements LadderCreator {
    private final Row[] rows;
    static final int MAX_LINE= (int) (LINE.getIntValue()* LINE.getValue()*RATIO.getValue());

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
                Position a = RandomGenerator.randomNumber(GreaterThanOne.from(LINE.getIntValue()));
                Position b = RandomGenerator.randomNumber(GreaterThanOne.from(LINE.getIntValue()));
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

