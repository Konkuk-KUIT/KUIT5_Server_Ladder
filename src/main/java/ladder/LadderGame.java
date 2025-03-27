package ladder;

import ladder.creator.BasicLadderCreator;

public class LadderGame {

    private final BasicLadderCreator ladderCreator;

    public LadderGame(BasicLadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }

    public void printLadder(String size) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.printLadder(size,0,Position.from(0));
    }
}
