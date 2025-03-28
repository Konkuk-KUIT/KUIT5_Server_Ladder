package ladder;

import ladder.creator.AutoLadderCreator;
import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator LadderCreator;
    // auto ,custom으로 짜기 Ladder random 이랑 custom 을 돌려

    private LadderGame(LadderCreator LadderCreator) {
        this.LadderCreator = LadderCreator;
    }

    public static LadderGame createCustomLadderGame(CustomLadderCreator customLadderCreator) {
        return new LadderGame(customLadderCreator);
    }
    public static LadderGame createAutoLadderGame(AutoLadderCreator autoLadderCreator) {
        return new LadderGame(autoLadderCreator);
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(LadderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }
}
