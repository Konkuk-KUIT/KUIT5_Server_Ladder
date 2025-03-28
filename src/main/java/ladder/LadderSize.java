package ladder;

// 사다리의 크기를 설정하는 클래스
public class LadderSize {

    // 사람 수
    private final int numberOfPerson;

    // 사다리 톺이
    private final int numberOfRow;

    // 사다리의 크기 설정
    public LadderSize(int numberOfPerson, int numberOfRow) {
        validate(numberOfPerson, numberOfRow);
        this.numberOfPerson = numberOfPerson;
        this.numberOfRow = numberOfRow;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    // 사다리 크기 유효성 검사 -> Enum 사용
    private void validate(int numberOfPerson, int numberOfRow) {
        System.out.println("LadderSize 유효성 검사 중... 사람 수: " + numberOfPerson + ", 높이: " + numberOfRow);
        if (numberOfPerson < 2) {
            System.out.println("사람 수가 2 미만입니다: " + numberOfPerson);
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());
        }
        if (numberOfRow < 1) {
            System.out.println("사다리 높이가 1 미만입니다: " + numberOfRow);
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());
        }
    }
}

