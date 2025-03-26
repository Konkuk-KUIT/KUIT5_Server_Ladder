public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(int row, int numberOfPerson) {
        Ladder ladder = Ladder.create(row, numberOfPerson);
        return new LadderGame(ladder, new RandomLadderCreator());
    }
}
