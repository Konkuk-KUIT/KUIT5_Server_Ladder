public class LadderGame {
    private final Ladder ladder;

    private LadderGame(LadderCreator ladderCreator, NaturalNumber row, NaturalNumber numberOfPerson) {
        this.ladder = ladderCreator.createLadder(row, numberOfPerson);
    }

    public static LadderGame create(LadderCreator ladderCreator, NaturalNumber row, NaturalNumber numberOfPerson) {
        return new LadderGame(ladderCreator, row, numberOfPerson);
    }

    public int run(int startIndex) {
        return ladder.run(startIndex);
    }
}