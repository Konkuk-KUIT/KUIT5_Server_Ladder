package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.UserLadderCreator;

// 게임의 실행을 담당하는 메인 컨트롤러
public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    // 게임 컨트롤러 역할, 게임을 실행시키고 결과값 반환.
    // 게임 전체를 실행시키는 컨트롤러 (게임을 관리하는 운영자)
    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }
}
