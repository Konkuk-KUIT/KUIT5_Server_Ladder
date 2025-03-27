package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderCreatorTest {
    @Test
    @DisplayName("사다리 출력 테스트")
    void ladderPrinter ()  {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        // 초기화 하고 -> LadderGame 객체 (컨트롤러를 담당하는)

        //when
        UserLadderCreator ladderCreator = new UserLadderCreator(numberOfRow, numberOfPerson);
        //LadderGame ladderGame = new LadderGame(ladderCreator);
        LadderGame ladderGame = LadderGameFactory.createUserLadderGame(ladderCreator);
        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));

        //then
        // 여기서 출력을 해야함!
        ladderGame.run(Position.from(0));
    }



    @Test
    @DisplayName("자동 생성 사다리 게임 실행 테스트")
    void autoLadderCreator()  {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(4);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        AutoLadderCreator ladderCreator = new AutoLadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderCreator);

        //then
        ladderGame.run(Position.from(0));
    }

}