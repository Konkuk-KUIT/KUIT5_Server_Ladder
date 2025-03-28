package ladder.game;

import ladder.creator.ArtificialLadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {


    public static LadderGame createLadderGame(ArtificialLadderCreator ladderCreator) {
        return new LadderGame(ladderCreator);
    }

    public static LadderGame createRandomLadderGame(RandomLadderCreator randomLadderCreator) {
        return new LadderGame(randomLadderCreator);
    }


}
