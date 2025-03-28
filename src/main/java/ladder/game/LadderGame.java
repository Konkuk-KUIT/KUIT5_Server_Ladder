package ladder.game;

import ladder.Position;
import ladder.creator.LadderGenerator;

public class LadderGame {

    private final LadderGenerator ladderGenerator;

    public LadderGame(LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderGenerator.getRows());
        return ladderRunner.run(position);
    }
}