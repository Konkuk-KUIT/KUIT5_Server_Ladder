import creator.LadderCreator;

public class LadderGameFactory {
    // 정적 팩토리 메서드 패턴 활용
    public static LadderGame createRandomLadderGame(LadderSize ladderSize){
        Ladder ladder = new Ladder(ladderSize);
        LadderCreator creator = new RandomLadderCreator(ladder, ladderSize);
        return new LadderGame(creator,ladder);
    }

    public static LadderGame createManualLadderGame(LadderSize ladderSize){
        Ladder ladder = new Ladder(ladderSize);
        LadderCreator creator = new ManualLadderCreator(ladder);
        return new LadderGame(creator, ladder);
    }

}
