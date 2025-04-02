public class LadderGameFactory {

    public static LadderGame createManualLadderGame(NaturalNumber row, NaturalNumber col) {
        Ladder ladder = Ladder.from(row, col);
        LadderCreator creator = LadderCreator.from();
        return new LadderGame(ladder, creator);
    }

    public static LadderGame createRandomLadderGame(NaturalNumber row, NaturalNumber col) {
        Ladder ladder = Ladder.from(row, col);
        LadderSize size = LadderSize.from(row, col);
        RandomLadderCreator creator = RandomLadderCreator.from();
        creator.drawRandomLines(ladder, size);
        return new LadderGame(ladder, creator);
    }
}
