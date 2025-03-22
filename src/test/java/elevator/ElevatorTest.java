package elevator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ElevatorTest {

    @Test
    @DisplayName("처음 엘레베이터는 1층에 위치해 있다.")
    void testInitialFloor() {
        Elevator elevator = new Elevator();
        assertThat(elevator.getCurrentFloor()).isEqualTo(1);
    }

    @Test
    @DisplayName("엘레베이터가 요청한 층으로 정상적으로 이동해야 한다.")
    void testMoveToFloor() {
        int targetFloor = 5;
        Elevator elevator = new Elevator();
        elevator.moveToFloor(targetFloor);
        int floorResult = elevator.getCurrentFloor();
        assertThat(floorResult).isEqualTo(targetFloor);
    }

    @Test
    @DisplayName("엘레베이터가 요청한 층으로 정상적으로 이동해야 한다.")
    void testMoveToFloor2() {
        // given
        int targetFloor = 5;
        Elevator elevator = new Elevator();

        // when
        elevator.moveToFloor(targetFloor);
        int floorResult = elevator.getCurrentFloor();

        // then
        assertThat(floorResult).isEqualTo(targetFloor);
    }

    @Test
    @DisplayName("엘레베이터에 요청할 층은 1 이상 10 이하의 수만 가능하다. (0 입력)")
    void throwExceptionWhenTargetFloorInvalid() {
        // given
        String expectedErrorMessage = "요청할 층은 1 이상 10 이하의 수만 가능합니다.";
        Elevator elevator = new Elevator();
        int targetFloor = 0;

        // when & then
        assertThatThrownBy(() -> elevator.moveToFloor(targetFloor))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }


    @Test
    @DisplayName("엘레베이터에 요청할 층은 1 이상 10 이하의 수만 가능하다. (11 입력)")
    void throwExceptionWhenTargetFloorInvalid2() {
        // given
        String expectedErrorMessage = "요청할 층은 1 이상 10 이하의 수만 가능합니다.";
        Elevator elevator = new Elevator();
        int targetFloor = 11;

        // when & then
        assertThatThrownBy(() -> elevator.moveToFloor(targetFloor))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 11, 12})
    @DisplayName("엘레베이터에 요청할 층은 1 이상 10 이하의 수만 가능하다.")
    void throwExceptionWhenTargetFloorInvalid3(int givenTargetFloor) {
        // given
        String expectedErrorMessage = "요청할 층은 1 이상 10 이하의 수만 가능합니다.";
        Elevator elevator = new Elevator();

        // when & then
        assertThatThrownBy(() -> elevator.moveToFloor(givenTargetFloor))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }
}