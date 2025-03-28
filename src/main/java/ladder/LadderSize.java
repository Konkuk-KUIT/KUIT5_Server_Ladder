package ladder;

public class LadderSize<A extends GreaterThanOne, B extends GreaterThanOne> {
    public final A numberOfRow;
    public final B numberOfPerson;

    public LadderSize(A first, B second) {
        this.numberOfRow = first;
        this.numberOfPerson = second;
    }

}
