package ladder;

import ladder.creator.AutoLadderCreator;
import ladder.creator.CustomLadderCreator;

public class LadderGameFactory {

    static final GreaterThanOne MAX_RANDOM_NUMBER = new GreaterThanOne(AutoLine.LINE.getIntValue());
    public static LadderGame createRandomLadderGame() {
        return LadderGame.createAutoLadderGame(new AutoLadderCreator(new LadderSize<>(MAX_RANDOM_NUMBER, MAX_RANDOM_NUMBER)));
    }
    public static LadderGame createCustomLadderGame(CustomLadderCreator customLadderCreator) {
        return LadderGame.createCustomLadderGame(customLadderCreator);
    }

}
