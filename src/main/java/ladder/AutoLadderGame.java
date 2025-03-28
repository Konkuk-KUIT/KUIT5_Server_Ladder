package ladder;

import java.util.Random;

public class AutoLadderGame implements LadderCreator{
    // 비슷한데 커스텀으로 ladderGame클래스 --> ladderRandomGame & ladderCustomGame
    private Ladder ladder;


    public AutoLadderGame(LadderSize ladderSize){
        this.ladder = new Ladder(ladderSize);
        drawLine(ladderSize);
    }

    public void gameStart(LadderSize ladderSize) {
        for(int i = 0; i< ladderSize.getNumberOfPerson(); i++){
            System.out.println(i+"번 유저 게임 시작");
            ladder.run(i);
            System.out.println();
        }
    }

    @Override
    public void drawLine(LadderSize ladderSize){
        //Auto 특성에 맞게 랜덤으로 생성
        Random random = new Random();
        int lineNum = ladderSize.getLineNum();
        for(int i=0; i<lineNum;i++){
            int rowNum = random.nextInt(ladderSize.getNumberOfRow());
            int columnNum = random.nextInt(ladderSize.getNumberOfPerson()-1);
            if(!canDrawLine(rowNum, columnNum)){
                i--;
                continue;

            }
            ladder.drawLine(rowNum,columnNum);
            continue;
        }
    }

    private boolean canDrawLine(int rowNum, int columnNum) {
        return !ladder.getRows()[rowNum].getSet().contains(columnNum) && !ladder.getRows()[rowNum].getSet().contains(columnNum - 1) && !ladder.getRows()[rowNum].getSet().contains(columnNum + 1);
    }
}