import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    //  테스트를 어디까지 작성해야 할 지

    @Test
    @DisplayName("범위 밖에 사다리를 그리게 되면 에러가 발생한다")
    public void testDraw(){
        //given
        int rows = 3;
        int numberOfPerson = 5;

        Ladder ladder = new Ladder(rows, numberOfPerson);
        Position position = new Position(rows, numberOfPerson);




        //when
        assertThatThrownBy(()-> ladder.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid row position(check row index)");
    }



    @Test
    @DisplayName("사다리 타기를 진행하면 범위내 모든 수가 정상적으로 한번씩 나온다.")
    public void ladder_run_test(){
        //given
        int rows = 20;
        int numberOfPerson = 5;
        Ladder ladder = new Ladder(rows, numberOfPerson);



        List<Integer> checkList = new ArrayList<>(numberOfPerson);


        //when
        for(int i = 0; i < numberOfPerson; i++){
            int result = ladder.run(i);
            checkList.add(result);
        }
        checkList.sort(Integer::compareTo);

        //then
        int index = 0;
        for (int result : checkList){
            assertThat(result).isEqualTo(index);
            index++;
        }
    }



    @ParameterizedTest
    @CsvSource({
            "5, 3", // rows = 5, numberOfPerson = 3
            "7, 4", // rows = 7, numberOfPerson = 4
            "10, 6" // rows = 10, numberOfPerson = 6
    })
    @DisplayName("line 긋기 테스트")
    public void drawLine_test(int rows, int numberOfPerson){

        Ladder ladder = new Ladder(rows, numberOfPerson);

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < numberOfPerson-1; j++){
                Position position = new Position(i, j);
                ladder.drawLine(position);
            }
        }
    }

    @ParameterizedTest
    @CsvSource({
            "5,3",
            "7,4",
            "10,6"
    })
    @DisplayName("통합 테스트")
    public void integration_test(int rows, int numberOfPerson){
        //given
        Ladder ladder = new Ladder(rows, numberOfPerson);
        for (int i = 0 ; i<numberOfPerson; i++){
            for(int j = 0; j<numberOfPerson-1; j++){
                Random random = new Random();
                if(random.nextBoolean()) {
                    Position position = new Position(i, j);
                    ladder.drawLine(position);
                }
            }
        }

        //  when & then
        for(int i = 0 ; i<numberOfPerson; i++){
            ladder.run(i);
        }

    }




}