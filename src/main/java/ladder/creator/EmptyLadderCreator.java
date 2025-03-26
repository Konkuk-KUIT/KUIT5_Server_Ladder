package ladder.creator;

import ladder.LadderGame.Ladder;
import ladder.LadderGame.Positive;

public class EmptyLadderCreator implements LadderCreator {

    private Positive numberOfPerson;
    private Positive height;

    public EmptyLadderCreator(Positive numberOfPerson, Positive height) {
        this.numberOfPerson = numberOfPerson;
        this.height = height;
    }

    @Override
    public Ladder createLadders() {
        return Ladder.of(numberOfPerson, height);
    }
}
