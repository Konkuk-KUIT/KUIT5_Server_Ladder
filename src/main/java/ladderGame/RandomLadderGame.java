package ladderGame;

import java.util.ArrayList;
import java.util.Random;

public class RandomLadderGame implements CreateLadderGame {

    @Override
    public LadderGame create(LadderGame ladderGame) {
        int person = ladderGame.getWidth();
        int height = ladderGame.getHeight();
        int numberOfLadderLine = person * height * 3 / 10;

        validateSolo(person);
        Random random = new Random();

        ArrayList<Position> positions = getPositions(height, person);

        while(numberOfLadderLine > 0) {
            int randomIndex = random.nextInt(positions.size());
            Position position = positions.get(randomIndex);
            positions.remove(randomIndex);
            ladderGame.drawLine(position);
            numberOfLadderLine--;

            positions = updatePositions(positions, ladderGame);
        }

        return ladderGame;
    }

    private static void validateSolo(int person) {
        if (person == 1) {
            throw new IllegalArgumentException(ExceptionCode.NO_SOLO_RANDOM_LADDER.getMessage());
        }
    }

    private static ArrayList<Position> getPositions(int height, int person) {
        ArrayList<Position> positions = new ArrayList<>();

        for(int possibleRow = 1; possibleRow <= height; possibleRow++) {
            for(int possibleColumn = 1; possibleColumn < person; possibleColumn++) {
                Position possiblePosition = new Position(possibleRow, possibleColumn, height, person);
                positions.add(possiblePosition);
            }
        }

        return positions;
    }

    private static ArrayList<Position> updatePositions(ArrayList<Position> positions, LadderGame ladderGame) {
        ArrayList<Position> newPositions = new ArrayList<>();

        for (Position position : positions) {
            if (!ladderGame.isAdjLine(position))
                newPositions.add(position);
        }

        return newPositions;
    }
}
