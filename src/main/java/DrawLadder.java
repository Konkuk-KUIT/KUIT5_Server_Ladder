public class DrawLadder {
    private final Ladder ladder;

    DrawLadder(Ladder ladder){
        this.ladder=ladder;
    }

    public void draw(Position p) {
        if(Position.LessThenZero(p)){
            return;
        }
        if(ladder.impossibleLine(p)){
            return;
        }
        if(!ladder.CanLine(p)){
            return;
        }
        ladder.setLine(p);
    }
}
