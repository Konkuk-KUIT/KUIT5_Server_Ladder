public class Ladder {

    //높이, 사람 수 정보
    private final LadderInfo ladderInfo;
    //가로선 정보
    private final LadderBars ladderBars;

    public int getNumberOfMember(){
        return ladderInfo.getNumberOfMember();
    }

    public int getHeight(){
        return ladderInfo.getHeight();
    }

    public Ladder(final int numberOfMember, final int height) {
        ladderInfo = new LadderInfo(numberOfMember, height);
        ladderBars = new LadderBars(numberOfMember, height);
    }

    public void drawLine(final int line, final int height){
        ladderBars.drawBar(line, height);
    }

    public int run(final int startLine){
        return ladderBars.run(startLine);
    }

}
