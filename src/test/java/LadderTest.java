import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


class LadderTest {
    @Test
    @DisplayName("초기 배열의 모든 값은 0이다.")
    void ladderInitializationSuccess() {
        // given
        int height = 5;
        int memberNum = 4;

        // when
        Ladder ladder = new Ladder(height, memberNum);

        // then
        int[][] result = ladder.getLadderArray();
        for (int[] row : result) {
            for (int cell : row) {
                assertThat(cell).isEqualTo(0);
            }
        }
        // 테스트에서는 로직 사용 X. only 검증만
    }

    @Test
    @DisplayName("사다리의 높이는 1이상이어야 한다.")
    void ladderInitializationFailHeightLessThan1() {
        // given, when, then
        assertThatThrownBy(() -> new Ladder(0, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("행과 열의 크기는 1 이상이어야 합니다");

    }

    @Test
    @DisplayName("사다리의 너비는 1이상이어야 한다.")
    void ladderInitializationFailMemberNumLessThan1() {
        // given, when, then
        assertThatThrownBy(() -> new Ladder(5, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("행과 열의 크기는 1 이상이어야 합니다");
    }

    @Test
    @DisplayName("사다리에 선을 그리면 양쪽배열값에 1과 -1이 차례로 할당된다")
    void drawLineSuccess() {
        // given
        Ladder ladder = new Ladder(5, 5);
        Position position = new Position(2, 2);

        // when
        ladder.drawLine(position);

        // then
        int[][] result = ladder.getLadderArray();
        assertThat(result[2][2]).isEqualTo(1); // 다리시작위치
        assertThat(result[2][3]).isEqualTo(-1); // 다리시작위치
    }

    @Test
    @DisplayName("이미 배열값이 있을 때 선을 추가할 수 없음")
        // 메서드명 일관적으로
    void drawLineFail_AlreadyHasLine() {
        // given
        Ladder ladder = new Ladder(5, 5);
        Position position1 = new Position(2, 2);  // 첫 번째 다리 추가 위치
        Position position2 = new Position(2, 1);  // 겹치는 위치

        // 첫번째 다리 추가
        ladder.drawLine(position1); // 첫 번째 다리 추가

        // when : 기존 다리 근처에 다리 선 추가 시도
        int[][] beforeDraw = ladder.getLadderArray();
        ladder.drawLine(position2);

        // then
        assertThat(ladder.getLadderArray()).isDeepEqualTo(beforeDraw);
    }

    @Test
    @DisplayName("사다리를 그릴 때 (0 ~ 사다리높이-1), (0 ~ 인원수-2) 범위의 값을 입력해야 함")
    void drawLineFail_OutOfRange() {
        // given
        Ladder ladder = new Ladder(5, 5);
        Position invalidPosition = new Position(5, 5); // 배열 범위 초과

        // when&then
        assertThatThrownBy(() -> ladder.drawLine(invalidPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("(0 ~ 사다리높이-1), (0 ~ 인원수-2) 범위의 값을 입력하세요.");
    }

    @Test
    @DisplayName("run() 실행시 올바른 도착사다리를 반환해야 함")
    void testRunSuccess() {
        // given
        Ladder ladder = new Ladder(5, 5);
        Position position = new Position(2, 2);
        ladder.drawLine(position);

        // when
        int result = ladder.run(2);

        // then
        assertThat(result).isEqualTo(3); // 예상도착위치
    }

    @Test
    @DisplayName("run()에 배열값을 벗어나는 숫자를 전달하면 안됨")
    void testRunFail_OutOfRange() {
        // given
        Ladder ladder = new Ladder(5, 5);

        // when
        int result = ladder.run(10);

        // then
        assertThat(result).isEqualTo(-1); // 유효하지 않은 경우 -1번째 사다리 반환
    }

    @ParameterizedTest
    @DisplayName("다양한 배열값에 다른 점 이동 테스트")
    @CsvSource({
            "0,2,2", // 값 0 -> 아래로 이동
            "1,2,3", // 값 1 -> 오른쪽 이동 후 아래로 이동
            "-1,2,1" // 값 -1 -> 왼쪽 이동 후 아래로 이동
    })
    void testDecideDirection(int ladderValue, int startCol, int expectedCol) {
        // given
        Ladder ladder = new Ladder(5, 5);
        ladder.getLadderArray()[0][startCol] = ladderValue; // 강제로 테스트 값 설정

        // when
        int resultCol = ladder.run(startCol);

        // then
        assertThat(resultCol).isEqualTo(expectedCol);
    }
}
