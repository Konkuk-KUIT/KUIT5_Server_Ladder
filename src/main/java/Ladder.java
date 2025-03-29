public class Ladder {
    private final int[][] ladder;
    private final NaturalNumber height;
    private final NaturalNumber people;
    private final LadderDrawer drawer;
    private final LadderRunner runner;

    public Ladder(int height, int people) {
        this.height = new NaturalNumber(height);
        this.people = new NaturalNumber(people);
        this.ladder = new LadderCreator(this.height, this.people).create();
        this.drawer = new LadderDrawer(ladder, this.height, this.people);
        this.runner = new LadderRunner(ladder, this.height, this.people);
    }

    public void drawLine(NonNegativeNumber row, NonNegativeNumber col) {
        drawer.draw(row, col);
    }

    public int run(int start) {
        return runner.run(start);
    }
}