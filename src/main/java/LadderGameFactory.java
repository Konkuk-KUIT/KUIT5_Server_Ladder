public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(int numberOfRow, int numberOfPerson) {
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        LadderCreator ladderCreator = new RandomLadderCreator(ladderSize);
        return new LadderGame(ladderSize, ladderCreator);
    }

    public static LadderGame createManualLadderGame(int numberOfRow, int numberOfPerson) {
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        Ladder ladder = new Ladder(ladderSize);
        return new LadderGame(ladder);
    }
}
