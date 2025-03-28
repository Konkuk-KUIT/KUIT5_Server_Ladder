import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderPrinterTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        // 매 테스트마다 표준출력을 ByteArrayOutputStream으로 변경
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        // 테스트가 끝난 뒤 표준출력을 원래대로 복구
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("현재위치(*) 마킹 확인")
    void printLadder_withCurrentPosition() {
        // given
        int row = 2;
        int col = 3;
        LadderGame ladderGame = LadderGameFactory.createDefaultLadderGame(row, col);

        // LadderCreator에서 Row[]를 받아 LadderPrinter 생성
        LadderCreator ladderCreator = ladderGame.getLadderCreator();
        LadderPrinter printer = LadderPrinter.from(ladderCreator.getRows());

        // when
        // 현재 위치는 (0,0)
        printer.printLadder(0, 0);

        // then
        String output = outContent.toString();
        // System.out.println(output); // 출력해보기
        // 0* 가 출력되었는지(현재 위치 표시) 확인
        assertTrue(output.contains("0*"));
    }
}
