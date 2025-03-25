package ladder.creator;

import ladder.LadderGame;
import ladder.LadderSize;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(AutoLadderCreator ladderCreator) {
        return new LadderGame(ladderCreator);
    }
}
