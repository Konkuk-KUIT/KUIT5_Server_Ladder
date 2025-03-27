package ladder;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static Position randomNumber(GreaterThanOne max) {
        int randomValue = ThreadLocalRandom.current().nextInt(max.getNumber()); // 0 이상 max 미만
        return Position.from(randomValue);
    }
}
