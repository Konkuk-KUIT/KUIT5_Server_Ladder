package ladder.creator;

import ladder.LadderGame;
import ladder.LadderSize;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(LadderSize ladderSize) {
        RandomLadderCreator creator = new RandomLadderCreator(ladderSize);
        creator.drawRandomLines(ladderSize);
        return new LadderGame(creator);
    }
}
