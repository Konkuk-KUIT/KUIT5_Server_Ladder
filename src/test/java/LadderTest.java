
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 모양 출력 - 같은 거 중복 안되는지 확인")
    void PrintLadder() {
        //given
        Ladder ladder = new Ladder(3, 3);
        ladder.drawLine(0, 0, 0, 1);
        ladder.drawLine(0, 1, 0, 2);
        ladder.drawLine(1, 1, 1, 2);
        ladder.drawLine(2, 0, 2, 1);

        //when&then
        ladder.printLadder();
    }

    @Test
    @DisplayName("사람이 1명일때")
    void OnePeople() {
        //given
        Ladder ladder = new Ladder(2, 1);

        //when
        int selectedPerson = ladder.run(1);

        //then
        assertThat(selectedPerson).isEqualTo(1);
    }

    @Test
    @DisplayName("사람이 2명 이상, 짝수일때")
    void moreThanTwoPeopleEven() {
        //given
        Ladder ladder = new Ladder(2, 2);
        ladder.drawLine(0, 0, 0, 1);
        ladder.drawLine(1, 0, 1, 1);

        //when
        int selectedPerson = ladder.run(1);

        //then
        assertThat(selectedPerson).isEqualTo(1);
    }

    @Test
    @DisplayName("사람이 2명 이상, 짝수일때")
    void moreThanTwoPeopleEven2() {
        //given
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(0, 0, 0, 1);
        ladder.drawLine(1, 1, 1, 2);
        ladder.drawLine(2, 2, 2, 3);

        //when
        int selectedPerson = ladder.run(1);

        //then
        assertThat(selectedPerson).isEqualTo(4);
    }

    @Test
    @DisplayName("사람이 2명 이상, 홀수일때")
    void moreThanTwoPeopleOdd() {
        //given
        Ladder ladder = new Ladder(3, 3);
        ladder.drawLine(0, 0, 0, 1);
        ladder.drawLine(1, 1, 1, 2);
        ladder.drawLine(2, 0, 2, 1);

        //when
        int selectedPerson = ladder.run(3);

        //then
        assertThat(selectedPerson).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 행에 2개 이상이 있을때")
    void moreThanOneLineInARow() {
        //given
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(0, 0, 0, 1);

        ladder.drawLine(1, 1, 1, 2);
        //아래 두개는 안그어짐.
        ladder.drawLine(1, 0, 1, 1);
        ladder.drawLine(1, 2, 1, 3);

        ladder.drawLine(2, 1, 2, 2);

        //when
        int selectedPerson = ladder.run(1);

        //then
        assertThat(selectedPerson).isEqualTo(2);
    }

    @Test
    @DisplayName("유효하지 않은 숫자가 넘어올 떄")
    void notAValidNumber() {
        //given
        Ladder ladder = new Ladder(3, 3);
        // 음수
//        ladder.drawLine(-1, 0, 0, 1);
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(-1, 0, 0, 1));

        // 범위 벗어난 것.
//        ladder.drawLine(3, 1, 0, 2);
//        ladder.drawLine(1, 3, 1, 2);
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(3, 1, 0, 2));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, 3, 1, 2));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, 0, 3, 2));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, 0, 0, 3));


        //나머지는 정상
        ladder.drawLine(0, 1, 0, 2);
        ladder.drawLine(1, 1, 1, 2);
        ladder.drawLine(2, 0, 2, 1);

        //when&then
        ladder.printLadder();
    }


}