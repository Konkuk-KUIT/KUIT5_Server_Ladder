public class LadderGame {

    private final Ladder ladder;
    private final int numberOfPlayers;

    // DI를 통해 LadderCreator 주입
    public LadderGame(LadderCreator ladderCreator, LadderSize ladderSize, int numberOfPlayers) {
        this.ladder = new Ladder(ladderCreator.createLadder(ladderSize));  // 자동/수동 생성
        this.numberOfPlayers = numberOfPlayers;
    }

    // 시작 위치를 받아서 결과를 출력하는 메서드
    public void play(int startX) {
        int result = ladder.move(startX);  // 사다리 이동
        System.out.println("Start Position: " + startX);
        System.out.println("Final Position: " + result);
    }

    // 여러 명이 참여할 수 있도록 각 플레이어의 게임을 실행하는 메서드
    public void playAll() {
        for (int i = 0; i < numberOfPlayers; i++) {
            play(i);  // 각 플레이어는 인덱스 0부터 시작
        }
    }
}