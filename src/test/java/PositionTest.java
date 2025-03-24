import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    @DisplayName("position 생성자 검증")
    void testPosition() {
        Position position = new Position();

        assertThat(position.hasBridge()).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("setHasBridge() 생성자 검증")
    void testSetHasBridge(boolean hasBridge) {
        Position position = new Position();
        position.setHasBridge(hasBridge);

        assertThat(position.hasBridge()).isEqualTo(hasBridge);
    }
}
