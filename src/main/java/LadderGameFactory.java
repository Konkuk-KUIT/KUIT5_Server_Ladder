public class LadderGameFactory {

    // 랜덤으로 사다리를 생성하고 게임을 시작하는 팩토리 메서드
    public static LadderGame createRandomLadderGame(LadderSize ladderSize, int numberOfPlayers) {
        return new LadderGame(new RandomLadderCreator(), ladderSize, numberOfPlayers);
    }

}