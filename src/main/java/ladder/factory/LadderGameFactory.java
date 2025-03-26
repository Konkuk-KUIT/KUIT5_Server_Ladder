package ladder.factory;

import ladder.LadderGame.LadderGame;
import ladder.LadderGame.Positive;
import ladder.creator.EmptyLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(Positive numberOfPerson, Positive height) {
        LadderCreator creator = new RandomLadderCreator(numberOfPerson, height);
        return new LadderGame(creator);
    }

    public static LadderGame createEmptyLadderGame(Positive numberOfPerson, Positive height) {
        LadderCreator creator = new EmptyLadderCreator(numberOfPerson, height);
        return new LadderGame(creator);
    }

}
