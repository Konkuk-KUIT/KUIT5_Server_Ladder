import ladder.LadderGame.LadderGame;
import ladder.LadderGame.Positive;
import ladder.exception.ExceptionMessage;
import ladder.factory.LadderGameFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderGameTest {

    @Test
    @DisplayName("사다리 생성")
    public void createLadder_Success(){
        LadderGame ladderGame = LadderGameFactory.createEmptyLadderGame(Positive.of(3), Positive.of(3));
    }

    @Test
    @DisplayName("행이나 열이 1인 잘못된 사다리 생성")
    public void createLadder_1HeightAnd1NumberOfPerson_ThrowException(){
        Assertions.assertThatThrownBy(()-> LadderGameFactory.createEmptyLadderGame(Positive.of(1), Positive.of(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());

        Assertions.assertThatThrownBy(()-> LadderGameFactory.createEmptyLadderGame(Positive.of(3), Positive.of(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    @DisplayName("잘못된 높이로 사다리 생성")
    public void createLadder_InvalidHeight_ThrowException(int givenInt){
        Assertions.assertThatThrownBy(()-> LadderGameFactory.createEmptyLadderGame(Positive.of(3), Positive.of(givenInt)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());

    }


    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    @DisplayName("잘못된 사람 수로 사다리 생성")
    public void createLadder_InvalidNumberOfMember_ThrowException(int givenInt){
        Assertions.assertThatThrownBy(() -> LadderGameFactory.createEmptyLadderGame(Positive.of(givenInt), Positive.of(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());

    }


    @Test
    @DisplayName("사다리 그리기")
    public void drawLine_Success(){

        LadderGame ladderGame = LadderGameFactory.createEmptyLadderGame(Positive.of(3), Positive.of(3));

        ladderGame.drawLine(1,1);
        ladderGame.drawLine(2,3);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 2",
            "3, 2",
            "2, 0",
            "2, 4"
    })
    @DisplayName("잘못된 인수로 사다리 그리기")
    public void drawLine_InvalidArguments_ThrowException(int line, int height){

        LadderGame ladderGame = LadderGameFactory.createEmptyLadderGame(Positive.of(3), Positive.of(3));

        Assertions.assertThatThrownBy(()-> ladderGame.drawLine(line, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());

    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "2, 2",
            "3, 2"
    })
    @DisplayName("중복, 바로 옆 사다리 그리기")
    public void drawLine_WrongPosition_ThrowException(int line, int height){

        LadderGame ladderGame = LadderGameFactory.createEmptyLadderGame(Positive.of(4),Positive.of(4));

        ladderGame.drawLine(2,2);

        Assertions.assertThatThrownBy(()-> ladderGame.drawLine(line, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());

    }

    @Test
    @DisplayName("사다리 run() 테스트")
    public void run_NoBars_Success(){

        LadderGame ladderGame = LadderGameFactory.createEmptyLadderGame(Positive.of(3), Positive.of(3));

        Assertions.assertThat(ladderGame.run(1)).isEqualTo(1);
        Assertions.assertThat(ladderGame.run(2)).isEqualTo(2);
        Assertions.assertThat(ladderGame.run(3)).isEqualTo(3);
    }

    @Test
    @DisplayName("라인 생성 후 run() 테스트")
    public void run_HasBar_Success(){
        LadderGame ladderGame = LadderGameFactory.createEmptyLadderGame(Positive.of(3), Positive.of(3));

        ladderGame.drawLine(1,1);
        ladderGame.drawLine(2,2);

        Assertions.assertThat(ladderGame.run(1)).isEqualTo(3);
        Assertions.assertThat(ladderGame.run(2)).isEqualTo(1);
        Assertions.assertThat(ladderGame.run(3)).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,4})
    @DisplayName("잘못된 인수로 run()")
    public void run_InvalidStartLine_throwException(int givenInt){

        LadderGame ladderGame = LadderGameFactory.createEmptyLadderGame(Positive.of(3), Positive.of(3));

        Assertions.assertThatThrownBy(()-> ladderGame.run(givenInt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_POSITION.getMessage());

    }


    @Test
    @DisplayName("랜덤 사다리 생성")
    public void create_RandomLadder(){
        LadderGame randomGame = LadderGameFactory.createRandomLadderGame(Positive.of(10),Positive.of(10));
        randomGame.run(4);
    }



}