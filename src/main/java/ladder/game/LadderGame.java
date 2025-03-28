package ladder.game;

import ladder.LadderRunner;
import ladder.position.Position;
import ladder.creator.ArtificialLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(ArtificialLadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }
    public LadderGame(RandomLadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }
}
