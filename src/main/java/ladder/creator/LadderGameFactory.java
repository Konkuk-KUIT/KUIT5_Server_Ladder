package ladder.creator;

import ladder.LadderGame;
import ladder.LadderSize;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(AutoLadderCreator ladderCreator) {
        return new LadderGame(ladderCreator);
    }

    public static LadderGame createUserLadderGame(UserLadderCreator ladderCreator) {
        return new LadderGame(ladderCreator);
    }
    // LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderCreator);


}
