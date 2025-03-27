package ladder;

import ladder.creator.AutoLadderCreator;
import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;

import java.util.HashSet;
import java.util.Random;

public class LadderGameFactory {
    // -> LadderGame을 생성
    static final int Line=10;
    static final GreaterThanOne MAX_RANDOM_NUMBER = new GreaterThanOne(Line);
    public static LadderGame createRandomLadderGame() {
        return LadderGame.createAutoLadderGame(new AutoLadderCreator(MAX_RANDOM_NUMBER,MAX_RANDOM_NUMBER));
    }
    public static LadderGame createCustomLadderGame(CustomLadderCreator customLadderCreator) {
        return LadderGame.createCustomLadderGame(customLadderCreator);
    }

}
