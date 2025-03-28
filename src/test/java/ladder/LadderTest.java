package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        //given
        int numberOfRow = 3;
        int numberOfPerson = 5;
        LadderSize size = new LadderSize(numberOfRow,numberOfPerson);
        //when
        Ladder ladder = new Ladder(size);

        //then
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        int numberOfPerson = 3;
        LadderSize size = new LadderSize(1,numberOfPerson);
        Ladder ladder = new Ladder(size);

        //given
        int nthOfPerson = 4;

        //then
        assertThatThrownBy(() -> ladder.run(nthOfPerson))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("AutoLadderGame 결과 확인")
    void testAutoLadderResult() {
        //when
        int numberOfPerson = 5;
        int numberOfRow = 4;
        LadderSize ladderSize = new LadderSize(numberOfRow,numberOfPerson);
        AutoLadderGame autoLadderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        autoLadderGame.gameStart(ladderSize);
        //사다리가 랜덤생성이므로 결과와 출력값 모두 랜덤으로 잡힐텐데 테스트 코드를 어떤 식으로 작성해야할지 모르겠다.

        //given
        int nthOfPerson = 0;

        //then
        //assertThat(ladder.run(nthOfPerson)).isEqualTo(2);
        /*
        //given
        nthOfPerson = 1;

        //then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(1);

        //given
        nthOfPerson = 2;

        //then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(0);
         */
    }

    @Test
    @DisplayName("CustomLadderGame 결과 확인")
    void testCustomLadderResult() {
        //when
        int numberOfPerson = 4;
        int numberOfRow = 3;
        LadderSize ladderSize = new LadderSize(numberOfRow,numberOfPerson);
        ladderSize.setDrawPoint(0,0);
        ladderSize.setDrawPoint(1,1);
        ladderSize.setDrawPoint(2,0);
        CustomLadderGame customLadderGame = LadderGameFactory.createCustomLadderGame(ladderSize);
        //사다리가 랜덤생성이므로 결과와 출력값 모두 랜덤으로 잡힐텐데 테스트 코드를 어떤 식으로 작성해야할지 모르겠다.

        //given
        int nthOfPerson = 0;

        //then
        assertThat(customLadderGame.gameStart(ladderSize,nthOfPerson)).isEqualTo(2);

        //given
        nthOfPerson = 1;

        //then
        assertThat(customLadderGame.gameStart(ladderSize,nthOfPerson)).isEqualTo(1);

        //given
        nthOfPerson = 2;

        //then
        assertThat(customLadderGame.gameStart(ladderSize,nthOfPerson)).isEqualTo(0);
    }
    /*
    //TDD를 활용해보자!
    @Test
    @DisplayName("ladder.run()을 실행할 때 시작 값 출력 확인")
    public void testPrintState(){
        //Given
        int numberOfPerson = 4;
        int row = 3;

        Ladder ladder = new Ladder(row, numberOfPerson);
        //When
        ladder.drawLine(0,0);
        ladder.drawLine(1,1);
        ladder.drawLine(2,0);
        ladder.run(0);
        //Then
        assertThat()
    }*/
}
