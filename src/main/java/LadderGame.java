public class LadderGame {

    private final Ladder ladder;
    private final DrawLadder drawLadder;

    public LadderGame(int height, int numberOfPerson) {
        if(height < 0 || numberOfPerson < 0) {
            throw new IllegalArgumentException("입력이 0보다 커야합니다");
        }
        ladder = new Ladder(new int[height][numberOfPerson]);
        this.drawLadder = new DrawLadder(this.ladder);
    }

    public void drawLine(Position p){
        drawLadder.draw(p);
    }

    public int run(int number){
        if(!ladder.canRun(number)){
            return -1;
        }
        return move(number-1,0)+1;
    }

    int move(int number, int height){
        if(height>= ladder.getHeight()){
            return number;
        }
        else{
            return move(number+ladder.getValue(new Position(number,height)),height+1);
        }
    }

}
