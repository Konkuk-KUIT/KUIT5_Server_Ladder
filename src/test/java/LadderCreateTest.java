import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderCreateTest {
    @ParameterizedTest
    @ValueSource(ints = {-43, -2, 0})
    @DisplayName("사다리 생성 - 잘못된 참가 인원")
    void testCreateWithInvalidGivenNumberOfPerson(int numberOfPerson){
        int givenRow = 8;

        assertThatThrownBy(() -> Ladder.create(givenRow, numberOfPerson)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-43, -2, 0})
    @DisplayName("사다리 생성 - 잘못된 사다리 높이 수")
    void testCreateWithInvalidGivenRow(int row){
        int givenNumberOfPerson = 5;

        assertThatThrownBy(() -> Ladder.create(row, givenNumberOfPerson)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
    }

    @Test
    @DisplayName("사다리 생성 - 정상 작동")
    void testDrawLineWhenSelectedLineIsNotAvailableAtLeft(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);
    }
}
