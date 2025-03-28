import creator.LadderCreator;

public class ManualLadderCreator implements LadderCreator {

    private final Ladder ladder;

    public ManualLadderCreator(Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public void drawLine() {
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 2);
        ladder.drawLine(2, 1);
    }
}
