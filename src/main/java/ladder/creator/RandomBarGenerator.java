package ladder.creator;

import ladder.LadderGame.Ladder;
import ladder.LadderGame.Positive;

import java.util.Random;

public class RandomBarGenerator {

    private final Random random = new Random();
    private final Positive numberOfPerson;
    private final Positive height;

    private RandomBarGenerator(Positive numberOfPerson, Positive height) {
        this.numberOfPerson = numberOfPerson;
        this.height = height;
    }

    public static RandomBarGenerator of(Positive numberOfPerson, Positive height){
        return new RandomBarGenerator(numberOfPerson, height);
    }

    //들어온 Ladder에 랜덤한 가로선을 그어준다.
    public void createRandomBar(Ladder randomLadder){

        int numberOfRequiredBar = calculateNumberOfRequiredBars();
        int numberOfRandomCreateBar = 0;

        while(numberOfRandomCreateBar <= numberOfRequiredBar){
            try {
                randomLadder.drawLine(createRandomLine(), createRandomHeight());
                numberOfRandomCreateBar++;
            } catch (IllegalArgumentException e){
                continue;
            }
        }

    }


    public int calculateNumberOfRequiredBars(){
        return (int) Math.round(0.3 * numberOfPerson.getNumber() * height.getNumber());
    }

    public int createRandomLine() {
        return random.nextInt(numberOfPerson.getNumber() - 1) + 1;
    }

    public int createRandomHeight() {
        return random.nextInt(height.getNumber()) + 1;
    }
}
