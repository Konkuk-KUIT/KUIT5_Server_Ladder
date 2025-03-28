/*package ladder;

import ladder.creator.LadderCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderCreator ladderCreator = new LadderCreator(numberOfRow, numberOfPerson);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new LadderCreator(GreaterThanOne.from(2), numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(1));
        ladderCreator.drawLine(Position.from(2),Position.from(0));

        //given
        Position position = Position.from(0);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(2);

        //given
        position = Position.from(1);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(1);

        //given
        position = Position.from(2);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 2",
            "1, 1",
            "2, 0"
    })
    @DisplayName("사다리 결과 확인 (ParameterizedTest 적용)")
    void testLadderResult(int input, int expectedResult) {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));
        ladderCreator.drawLine(Position.from(2), Position.from(0));

        //given
        Position position = Position.from(input);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(expectedResult);
    }

}*/

/*
package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static ladder.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LadderGameTest {

    private LadderCreator creator;

    @BeforeEach
    void setUp() {
        creator = new LadderCreator();
    }

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        // 사다리 크기 설정
        LadderSize size = new LadderSize(5, 3);
        // 사다리 생성
        Ladder ladder = new Ladder(size);

        // 사다리가 정상적으로 생성되었는지 확인
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사다리 크기 유효성 검사")
    void testLadderSizeValidation() {
        // 유효하지 않은 사람 수로 사다리 크기 생성 시도
        assertThatThrownBy(() -> new LadderSize(1, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_NUMBER.getMessage());

        // 유효하지 않은 높이로 사다리 크기 생성 시도
        assertThatThrownBy(() -> new LadderSize(5, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_NUMBER.getMessage());
    }

    @Test
    @DisplayName("사다리 게임 실행 테스트")
    void testLadderGamePlay() {
        // 테스트를 위한 입력 스트림 설정
        String input = "3\n4\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // 사다리 게임 생성 및 실행
        LadderGame game = new LadderGame();

        // 예외가 발생하지 않고 정상 실행되는지 확인
        assertThat(game).isNotNull();

        // 원래 입력 스트림 복원
        System.setIn(System.in);
    }

    @Test
    @DisplayName("유효하지 않은 시작 위치 예외 테스트")
    void testInvalidStartPosition() {
        // 테스트를 위한 입력 스트림 설정
        String input = "3\n4\n-1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // 사다리 게임 생성
        LadderGame game = new LadderGame();

        // 유효하지 않은 시작 위치로 인한 예외 발생 확인
        assertThatThrownBy(() -> game.play())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_POSITION.getMessage());

        // 원래 입력 스트림 복원
        System.setIn(System.in);
    }

    @Test
    @DisplayName("사다리 자동 생성 테스트")
    void testLadderAutoCreation() {
        // 사다리 크기 설정
        LadderSize size = new LadderSize(5, 3);
        // 사다리 생성
        Ladder ladder = new Ladder(size);

        // 사다리 자동 생성
        creator.create(ladder, size);

        // 사다리가 정상적으로 생성되었는지 확인
        assertThat(ladder).isNotNull();
    }
}*/

package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static ladder.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LadderGameTest {

    private LadderCreator creator;

    @BeforeEach
    void setUp() {
        creator = new LadderCreator();
    }

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        // 사다리 크기 설정
        LadderSize size = new LadderSize(5, 3);
        // 사다리 생성
        Ladder ladder = new Ladder(size);

        // 사다리가 정상적으로 생성되었는지 확인
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사다리 크기 유효성 검사")
    void testLadderSizeValidation() {
        // 유효하지 않은 사람 수로 사다리 크기 생성 시도
        assertThatThrownBy(() -> new LadderSize(1, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_NUMBER.getMessage());

        // 유효하지 않은 높이로 사다리 크기 생성 시도
        assertThatThrownBy(() -> new LadderSize(5, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_NUMBER.getMessage());
    }

    @Test
    @DisplayName("사다리 게임 실행 테스트")
    void testLadderGamePlay() {
        // 테스트를 위한 입력 스트림 설정
        String input = "3\n4\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // 사다리 게임 생성 및 실행
        LadderGame game = new LadderGame();

        // 예외가 발생하지 않고 정상 실행되는지 확인
        assertThat(game).isNotNull();

        // 원래 입력 스트림 복원
        System.setIn(System.in);
    }

    @Test
    @DisplayName("유효하지 않은 시작 위치 예외 테스트")
    void testInvalidStartPosition() {
        // 테스트를 위한 입력 스트림 설정
        String input = "3\n4\n-1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // 사다리 게임 생성
        LadderGame game = new LadderGame();

        // 유효하지 않은 시작 위치로 인한 예외 발생 확인
        assertThatThrownBy(() -> game.play())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_POSITION.getMessage());

        // 원래 입력 스트림 복원
        System.setIn(System.in);
    }

    @Test
    @DisplayName("사다리 자동 생성 테스트")
    void testLadderAutoCreation() {
        // 사다리 크기 설정
        LadderSize size = new LadderSize(5, 3);
        // 사다리 생성
        Ladder ladder = new Ladder(size);

        // 사다리 자동 생성
        creator.create(ladder, size);

        // 사다리가 정상적으로 생성되었는지 확인
        assertThat(ladder).isNotNull();
    }
}

