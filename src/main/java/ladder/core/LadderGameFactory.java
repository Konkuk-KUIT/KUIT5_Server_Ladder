package ladder.core;

import ladder.creator.LadderAutoCreatorImpl;
import ladder.creator.LadderCreatorImpl;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        return new LadderGame(new LadderAutoCreatorImpl(ladderSize));
    }

    public static LadderGame createLadderGame(LadderSize ladderSize) {
        return new LadderGame(new LadderCreatorImpl(ladderSize));
    }
}