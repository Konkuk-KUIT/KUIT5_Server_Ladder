public class LadderGameFactory {

    LadderGame ladderGame;

    //정적 팩토리 메서드 패턴 사용하기...?
    public static LadderGame createRandomLadderGame(int row, int col){
        LadderSize ladderSize = LadderSize.from(row, col);
        DefaultLadderCreator emptyLadder=DefaultLadderCreator.of(ladderSize);;
        LadderCreator ladderCreator = RandomLadderCreator.of(emptyLadder);
        return LadderGame.of(ladderCreator);
    }

    public static LadderGame createDefaultLadderGame(int row, int col) {
        LadderSize ladderSize = LadderSize.from(row, col);
        LadderCreator ladderCreator = DefaultLadderCreator.of(ladderSize);
        return LadderGame.of(ladderCreator);
    }
}
