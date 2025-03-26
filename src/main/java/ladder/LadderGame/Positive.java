package ladder.LadderGame;

import ladder.exception.ExceptionMessage;

public class Positive {

    private final int number;

    private Positive(int value) {
        if (value < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());
        }
        this.number = value;
    }

    public static Positive of(int value){
        return new Positive(value);
    }

    public int getNumber() {
        return number;
    }

}