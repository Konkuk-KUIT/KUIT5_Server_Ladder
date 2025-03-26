package ladder.LadderGame;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final Ladder ladder;
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
        this.ladder = ladderCreator.createLadders();
    }

    public int run(int startLine){
        return ladder.run(startLine);
    }

    public void drawLine(int line, int height){
        ladder.drawLine(line, height);
    }

}
