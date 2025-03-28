package ladder;

public class Game {
    public static void main(String[] args) {
        try {
            // 게임 생성
            LadderGame ladderGame = new LadderGame();
            // 게임 시작
            ladderGame.play();
        } catch (Exception e) {
            System.err.println("게임 실행 중 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        }
    }
}