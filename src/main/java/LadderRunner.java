public class LadderRunner {
    private final Ladder ladder;

    public LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    public int run (int numOfPerson) {
        int selectedPerson = numOfPerson - 1;

    for (int i = 0; i < ladder.getRows().length; i++) {
        if (ladderLineValueEqualsZero(i, selectedPerson)) {
            continue;
        }
        selectedPerson = move(i, selectedPerson);
    }

    return selectedPerson + 1;
    }

    private int move(int row, int selectedPerson) {
    if (ladder.getRows()[row][selectedPerson] == 1) {
        return selectedPerson += 1;
    }
    if (ladder.getRows()[row][selectedPerson] == -1) {
        return selectedPerson -= 1;
    }
    return selectedPerson;
}
    private boolean ladderLineValueEqualsZero(int i, int selectedPerson) {
        return ladder.getRows()[i][selectedPerson] == 0;
    }
}