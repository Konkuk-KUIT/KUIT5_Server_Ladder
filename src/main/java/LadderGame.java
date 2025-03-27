public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder, LadderCreator ladderCreator) {
        this.ladder = ladder;
        ladderCreator.create(ladder);
    }

    public int run(int line) {
        return ladder.run(line);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
