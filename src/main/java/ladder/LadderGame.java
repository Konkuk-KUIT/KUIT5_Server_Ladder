package ladder;

import java.util.Scanner;

// 사다리 게임 실행 클래스
public class LadderGame {

    private final Scanner scanner;
    private final LadderCreator creator;

    public LadderGame() {
        this.scanner = new Scanner(System.in);
        this.creator = new LadderCreator();
    }


    // 게임 시작
    public void play() {
        System.out.println("===== 사다리 게임 =====");

        // 사람 수 입력 및 검증
        int numberOfPerson = inputNumber("사람 수를 입력하세요 (2 이상): ");
        if (numberOfPerson < 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());
        }

        // 사다리 높이 입력 및 검증
        int numberOfRow = inputNumber("사다리 높이를 입력하세요 (1 이상): ");
        if (numberOfRow < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());
        }

        LadderSize size = new LadderSize(numberOfPerson, numberOfRow);
        Ladder ladder = new Ladder(size);

        // 사다리 자동 생성
        creator.create(ladder, size);

        // 시작 위치 입력 및 검증
        int startPosition = inputNumber("시작 위치를 선택하세요 (0 ~ " + (numberOfPerson - 1) + "): ");
        if (startPosition < 0 || startPosition >= numberOfPerson) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }

        // 사다리 이동
        int result = ladder.run(startPosition);
        System.out.println("도착 위치는 " + result + " 번 입니다.");
    }

    // 사용자 입력
    private int inputNumber(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}
