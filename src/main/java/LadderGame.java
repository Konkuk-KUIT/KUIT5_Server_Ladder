public class LadderGame {
    private final Ladder ladder;
    private final LineCreator creator;

    public LadderGame(Ladder ladder, LineCreator creator) {
        this.ladder = ladder;
        this.creator = creator;
    }

    public int play(NaturalNumber start) {
        LadderRunner runner = LadderRunner.from();
        return runner.run(ladder, start);
    }

    public int[][] getLadderState() {
        return creator.getRows(ladder);
    }
}
