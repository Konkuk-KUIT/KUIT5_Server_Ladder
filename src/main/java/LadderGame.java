import creator.LadderCreator;

public class LadderGame {
    private final LadderCreator ladderCreator;
    private final Ladder ladder;

    public LadderGame(LadderCreator ladderCreator, Ladder ladder) {
        this.ladderCreator = ladderCreator;
        this.ladder = ladder;
    }

    public void startGame() {
        ladderCreator.drawLine();
    }


    public int runGame(int startPosition) {
        return ladder.run(startPosition);
    }
}
