package ladder.creator;

import ladder.*;

import static ladder.AutoLine.LINE;
import static ladder.AutoLine.RATIO;

public class AutoLadderCreator implements LadderCreator {
    private final Row[] rows;
    static final int MAX_LINE= (int) (LINE.getIntValue()* LINE.getValue()*RATIO.getValue());

    public AutoLadderCreator(LadderSize<GreaterThanOne,GreaterThanOne> ladderSize) {
        rows = new Row[ladderSize.numberOfRow.getNumber()];
        for (int i = 0; i < ladderSize.numberOfRow.getNumber(); i++) {
            rows[i] = new Row(ladderSize.numberOfPerson);
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

