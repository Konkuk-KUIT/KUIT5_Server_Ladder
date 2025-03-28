package ladder.game;

import ladder.GreaterThanOne;
import ladder.creator.*;

public class LadderGameFactory {

    private LadderGameFactory() {
        // 외부 접근을 막기 위함
    }

    public static LadderGame createManualLadderGame(GreaterThanOne rowCount, GreaterThanOne personCount) {
        LadderGenerator generator = new ManualLadderCreator(rowCount, personCount);
        return new LadderGame(generator);
    }

    public static LadderGame createRandomLadderGame(GreaterThanOne rowCount, GreaterThanOne personCount) {
        LadderGenerator generator = new RandomLadderCreator(rowCount, personCount);
        return new LadderGame(generator);
    }
}
