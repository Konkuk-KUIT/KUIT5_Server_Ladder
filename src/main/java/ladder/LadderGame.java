package ladder;

import ladder.creator.LadderCreatorInterface;

public class LadderGame {

    private final LadderCreatorInterface ladderCreator;

    public LadderGame(LadderCreatorInterface ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(position);
    }
}
