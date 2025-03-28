package ladder;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// 사다리 자동 생성 클래스
public class LadderCreator {

    private final Random random = new Random();

    // 사다리 자동 생성 메서드
    public void create(Ladder ladder, LadderSize size) {
        int maxLineCount = (int) (size.getNumberOfPerson() * size.getNumberOfRow() * 0.3);
        // 생성된 줄의 위치 저장용 Set
        Set<Position> lines = new HashSet<>();
        Set<Position> failedPositions = new HashSet<>(); // 실패한 위치 저장

        System.out.println("사다리 생성 시작: 목표 선 개수=" + maxLineCount);

        // 목표한 선 개수에 도달할 때까지 계속 시도
        while (lines.size() < maxLineCount) {
            // 모든 가능한 위치를 시도했는지 확인
            if (lines.size() + failedPositions.size() >= size.getNumberOfPerson() * size.getNumberOfRow()) {
                System.out.println("더 이상 선을 그릴 수 있는 위치가 없습니다.");
                break;
            }

            // 유효한 범위 내에서 랜덤 위치 생성
            int x = random.nextInt(size.getNumberOfPerson() - 1); // 마지막 column은 제외
            int y = random.nextInt(size.getNumberOfRow());

            Position position = new Position(x, y);

            // 이미 시도했거나 실패한 위치는 건너뜀
            if (lines.contains(position) || failedPositions.contains(position)) {
                continue;
            }

            if (isDrawable(lines, position)) {
                try {
                    ladder.drawLine(x, y);
                    lines.add(position);
                    System.out.println("선 그리기 성공: x=" + x + ", y=" + y);
                } catch (IllegalArgumentException e) {
                    failedPositions.add(position);
                }
            } else {
                failedPositions.add(position);
            }
        }

        System.out.println("사다리 생성 완료: 선의 개수=" + lines.size());
    }

    // 줄 생성 가능 여부 검사
    private boolean isDrawable(Set<Position> lines, Position position) {
        if (position.getX() <= 0) {
            // x가 0 이하면 left()가 음수가 되므로 left 검사 생략
            return !lines.contains(position) && !lines.contains(position.right());
        } else if (position.getX() >= Integer.MAX_VALUE - 1) {
            // x가 매우 큰 값이면 right()가 오버플로우될 수 있으므로 right 검사 생략
            return !lines.contains(position) && !lines.contains(position.left());
        } else {
            // 이미 같은 위치에 줄이 있거나, 인접한 곳에 선이 존재하면 false
            return !lines.contains(position)
                    && !lines.contains(position.left())
                    && !lines.contains(position.right());
        }
    }
}

