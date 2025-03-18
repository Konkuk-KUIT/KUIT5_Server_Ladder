import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("올바른 사다리 생성")
    void testValidLadder(){

        //given
        int validNumberOfMember1 = 1;
        int validHeight1 = 1;
        int validNumberOfMember2 = 5;
        int validHeight2 = 10;

        //when
        Ladder ladder1 = new Ladder(validNumberOfMember1, validHeight1);
        Ladder ladder2 = new Ladder(validNumberOfMember2,validHeight2);

        //then
        assertThat(ladder1.getNumberOfMember()).isEqualTo(validNumberOfMember1);
        assertThat(ladder1.getHeight()).isEqualTo(validHeight1);
        assertThat(ladder2.getNumberOfMember()).isEqualTo(validNumberOfMember2);
        assertThat(ladder2.getHeight()).isEqualTo(validHeight2);

    }

    @ParameterizedTest
    @ValueSource(ints = {-10,-1,0})
    @DisplayName("사다리 생성 시 잘못된 사람 수 입력")
    void throwExceptionWhenNumberOfMemberInvalid(int numberOfMember){

        //given
        String expectedErrorMessage = "사람 수는 1 이상이어야 합니다.";
        int validLadderHeight = 3;

        //when & then
        assertThatThrownBy(() -> new Ladder(numberOfMember, validLadderHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);;

    }

    @ParameterizedTest
    @ValueSource(ints = {-10,-1,0})
    @DisplayName("사다리 생성 시 잘못된 높이 입력")
    void throwExceptionWhenHeightInvalid(int ladderHeight){

        //given
        String expectedErrorMessage = "사다리 높이는 1 이상이어야 합니다.";
        int validNumberOfMember = 3;

        //when & then
        assertThatThrownBy(() -> new Ladder(validNumberOfMember, ladderHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

    }


    @Test
    @DisplayName("run() 메소드 테스트")
    void testRun(){

        //given
        Ladder ladder = new Ladder(3,4);
        int expectResult1 = 1;
        int expectResult2 = 2;
        int expectResult3 = 3;

        //when
        int result1 = ladder.run(1);
        int result2 = ladder.run(2);
        int result3 = ladder.run(3);

        //then
        assertThat(result1).isEqualTo(expectResult1);
        assertThat(result2).isEqualTo(expectResult2);
        assertThat(result3).isEqualTo(expectResult3);

    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,4})
    @DisplayName("run() 메소드에 잘못된 인수 입력")
    void throwExceptionWhenStartLineInvalid(int startLine){

        //given
        Ladder ladder = new Ladder(3,4);
        String expectedErrorMessage = "해당 위치에서는 시작할 수 없습니다.";

        //when & then
        assertThatThrownBy(() -> ladder.run(startLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

    }


    @Test
    @DisplayName("올바른 가로선 작성")
    void testDrawLine(){

        //given
        Ladder ladder = new Ladder(3,4);
        int expectResult1 = 3;
        int expectResult2 = 1;
        int expectResult3 = 2;

        //when
        ladder.drawLine(1,1);
        ladder.drawLine(2,2);

        int result1 = ladder.run(1);
        int result2 = ladder.run(2);
        int result3 = ladder.run(3);

        //then
        assertThat(result1).isEqualTo(expectResult1);
        assertThat(result2).isEqualTo(expectResult2);
        assertThat(result3).isEqualTo(expectResult3);

    }


    @Test
    @DisplayName("잘못된 라인으로 가로선 작성")
    void throwExceptionWhenDrawOnInvalidLine(){

        //given
        Ladder ladder = new Ladder(3,4);
        String expectedErrorMessage = "해당 위치에는 사다리를 둘 수 없습니다.";

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(0,4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

        assertThatThrownBy(() -> ladder.drawLine(3,4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

    }

    @Test
    @DisplayName("잘못된 높이로 가로선 작성")
    void throwExceptionWhenDrawOnInvalidHeight(){

        //given
        Ladder ladder = new Ladder(3,4);
        String expectedErrorMessage = "해당 위치에는 사다리를 둘 수 없습니다.";

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(2,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

        assertThatThrownBy(() -> ladder.drawLine(2,5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

    }

    @Test
    @DisplayName("중복이거나, 이미 존재하는 가로선 옆에 작성")
    void throwExceptionWhenDrawOnInvalidPosition(){

        //given
        Ladder ladder = new Ladder(4,4);
        String expectedErrorMessage = "해당 위치에는 사다리를 둘 수 없습니다.";

        ladder.drawLine(2,2);

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(1,2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
        assertThatThrownBy(() -> ladder.drawLine(2,2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
        assertThatThrownBy(() -> ladder.drawLine(3,2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

    }

}