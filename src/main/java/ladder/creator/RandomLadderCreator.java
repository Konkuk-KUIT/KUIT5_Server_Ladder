package ladder.creator;

import ladder.LadderGame.Ladder;
import ladder.LadderGame.Positive;

public class RandomLadderCreator implements LadderCreator {

    private Positive numberOfPerson;
    private Positive height;
    private RandomBarGenerator randomBarGenerator;

    public RandomLadderCreator(Positive numberOfPerson, Positive height) {
        this.numberOfPerson = numberOfPerson;
        this.height = height;
        this.randomBarGenerator = RandomBarGenerator.of(numberOfPerson, height);
    }

    @Override
    public Ladder createLadders() {
        Ladder randomLadder = Ladder.of(numberOfPerson, height);
        randomBarGenerator.createRandomBar(randomLadder);
        return randomLadder;
    }

}
