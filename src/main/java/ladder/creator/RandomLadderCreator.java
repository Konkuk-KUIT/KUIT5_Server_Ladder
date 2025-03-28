package ladder.creator;

import ladder.GreaterThanOne;
import ladder.position.LadderPosition;
import ladder.position.Position;
import ladder.Row;

import java.util.HashSet;



public class RandomLadderCreator implements LadderCreator {

    private final ArtificialLadderCreator ladderCreator;

    HashSet<LadderPosition> set = new HashSet<>();


//    public RandomLadderCreator(ArtificialLadderCreator ladderCreator) {
//        this.ladderCreator = ladderCreator;
//        int requiredLineNum = (int) (ladderCreator.getRowLength() * ladderCreator.getColumnLength() * 0.3);
//
//
//        while (set.size() < requiredLineNum) {
//            try{
//                Position row = Position.from((int) (Math.random() * ladderCreator.getRowLength()));
//                Position col = Position.from((int) (Math.random() * ladderCreator.getColumnLength()));
//
//                drawLine(row, col);
//                set.add(new LadderPosition(row,col));
//
//            }catch(Exception e){
//            }
//        }
//    }

    public RandomLadderCreator(GreaterThanOne row, GreaterThanOne col) {
        this.ladderCreator = new ArtificialLadderCreator(row, col);
        int requiredLineNum = (int) (ladderCreator.getRowLength() * ladderCreator.getColumnLength() * 0.3);


        while (set.size() < requiredLineNum) {
            try{
                Position r = getRandomInteger(ladderCreator.getRowLength());
                Position c = getRandomInteger(ladderCreator.getColumnLength());
                drawLine(r, c);
                set.add(new LadderPosition(r,c));

            }catch(Exception e){
            }
        }
    }


    private Position getRandomInteger(final int ladderCreator) {
        return Position.from((int) (Math.random() * ladderCreator));
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
