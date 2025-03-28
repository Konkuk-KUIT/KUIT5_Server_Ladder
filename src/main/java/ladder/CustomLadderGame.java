package ladder;

import java.util.Random;

public class CustomLadderGame implements LadderCreator{
    private Ladder ladder;

    // 커스텀 수정
    public CustomLadderGame(LadderSize ladderSize){
        this.ladder = new Ladder(ladderSize);
        drawLine(ladderSize);
    }

    public int gameStart(LadderSize ladderSize,int nthOfPerson) {
        int result = 0;
        System.out.println(nthOfPerson+"번 유저 게임 시작");
        result = ladder.run(nthOfPerson);
        System.out.println();
        return result;
    }

    @Override
    public void drawLine(LadderSize ladderSize){
        for(int i=0; i<ladderSize.getNumberOfRow();i++){
            for(int j=0; j<ladderSize.getNumberOfPerson()-1;j++){
                if(ladderSize.getDrawPoint()[i][j]==1){
                    ladder.drawLine(i,j);
                }
            }
        }
    }
    //이건 ladderSize 클래스에 넣어놓는게 더 객체 지향적일거 같음!
    private static int getLineNum(LadderSize ladderSize) {
        return (int) (ladderSize.getNumberOfRow() * ladderSize.getNumberOfPerson() * 0.3);
    }

    private boolean canDrawLine(int rowNum, int columnNum) {
        return !ladder.getRows()[rowNum].getSet().contains(columnNum) && !ladder.getRows()[rowNum].getSet().contains(columnNum - 1) && !ladder.getRows()[rowNum].getSet().contains(columnNum + 1);
    }
}
