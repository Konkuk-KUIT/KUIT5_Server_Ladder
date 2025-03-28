package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderRandomCreator;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        return new LadderGame(new LadderRandomCreator(ladderSize));
    }

    public static LadderGame createLadderGame(LadderSize ladderSize) {
        return new LadderGame(new LadderCreator(ladderSize));
    }
}
