package ladder.creator;

import ladder.LadderPosition;
import ladder.Position;
import ladder.Row;

import java.util.HashSet;



public class RandomLadderCreator implements LadderCreator {

    private final ArtificialLadderCreator ladderCreator;
    HashSet<LadderPosition> set = new HashSet<>();


    public RandomLadderCreator(ArtificialLadderCreator ladderCreator) {

        this.ladderCreator = ladderCreator;

        int requiredLineNum = (int) (ladderCreator.getRowLength() * ladderCreator.getColumnLength() * 0.3);


        while (set.size() < requiredLineNum) {
            try{
                Position row = Position.from((int) (Math.random() * ladderCreator.getRowLength()));
                Position col = Position.from((int) (Math.random() * ladderCreator.getColumnLength()));

                drawLine(row, col);
                set.add(new LadderPosition(row,col));

            }catch(Exception e){
            }
        }
    }


    @Override
    public void drawLine(Position row, Position col) {
        this.ladderCreator.drawLine(row, col);
    }

    @Override
    public Row[] getRows() {
        return this.ladderCreator.getRows();
    }
}
