package ladderGame;

public class Main {
    public static void main(String[] args) {
        int person = 5, ladderHeight = 5;
        int startNumber = 1;
        Ladder ladder = new Ladder(person, ladderHeight);

        ladder.drawLine(new Position(5, 1));
        ladder.drawLine(new Position(4, 2));
        ladder.drawLine(new Position(3, 1));
        ladder.drawLine(new Position(2, 2));
        ladder.drawLine(new Position(1, 3));

        LadderRunner ladderRunner = new LadderRunner(ladder, true);

        System.out.println(ladderRunner.run(new PositiveNumber(2)));
    }
}
