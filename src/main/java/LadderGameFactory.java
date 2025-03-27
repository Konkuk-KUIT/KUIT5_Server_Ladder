public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(NaturalNumber row, NaturalNumber numberOfPerson) {
        return LadderGame.create(new RandomLadderCreator(), row, numberOfPerson);
    }
}