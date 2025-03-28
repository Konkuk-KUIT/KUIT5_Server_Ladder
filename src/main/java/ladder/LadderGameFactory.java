package ladder;

public class LadderGameFactory {
    //createRandomLadderGame,createCustomLadderGame 생성 정적 메소드
    public static AutoLadderGame createRandomLadderGame(LadderSize ladderSize){
        AutoLadderGame randomGame = new AutoLadderGame(ladderSize);
        return randomGame;
    }

    public static CustomLadderGame createCustomLadderGame(LadderSize ladderSize){
        CustomLadderGame customGame = new CustomLadderGame(ladderSize);
        return customGame;
    }


}
