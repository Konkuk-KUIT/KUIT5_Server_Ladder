package ladderGame;

public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(int height, int person) {
        LadderGame ladderGame = new LadderGame(height, person);
        RandomLadderGame randomLadderGame = new RandomLadderGame();

        return randomLadderGame.create(ladderGame);
    }
}
