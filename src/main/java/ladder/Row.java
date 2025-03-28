package ladder;

import java.util.HashSet;

import static ladder.ErrorMessage.*;

public class Row {
    private final int[] row;
    private HashSet<Integer> set = new HashSet<>();
    // 사다리 생성자
    public Row(int numberOfPerson) {
        validateNumberOfPerson(numberOfPerson);
        row = new int[numberOfPerson];
    }

    // 사다리를 그리는 함수
    public void drawLine(int startPosition) {
        validateDrawLinePosition(startPosition);
        row[startPosition] = 1;
        row[startPosition + 1] = -1;
        set.add(startPosition);
    }

    // 유저의 움직임을 담당하는 함수
    public int nextPosition(int position) {
        validatePosition(position);
        if (isRight(position)) {
            return position + 1;
        }
        if (isLeft(position)) {
            return position - 1;
        }
        return position;
    }

    // 왼쪽에 길이 있는지 확인하는 boolean 함수
    private boolean isLeft(int position) {
        return row[position] == -1;
    }

    // 오른쪽에 길이 있는지 확인하는 boolean 함수
    private boolean isRight(int position) {
        return row[position] == 1;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException(NO_NEGATIVE_ZERO.getMessage());
        }
    }
    // 유저가 올바른 위치인지 확인하는 함수
    private void validatePosition(int position) {
        if (position >= row.length || position < 0) {
            throw new IllegalArgumentException(NO_OUTSIDE.getMessage());
        }
    }

    // 라인을 그리기에 적합한지 확인하는 함수
    private void validateDrawLinePosition(int startPosition) {
        if (startPosition >= row.length - 1 || startPosition < 0 || row[startPosition] == -1 || row[startPosition + 1] == 1) {
            throw new IllegalArgumentException(CANTDRAWPOSITION.getMessage());
        }
    }

    public int[] getRow() {
        return row;
    }

    public HashSet<Integer> getSet() {
        return set;
    }
}