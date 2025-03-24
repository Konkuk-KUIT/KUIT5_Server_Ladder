public class Ladder {

    private final int[][] ladder;

    // 여기 한번 잡기
    private final Position ladderPosition;

    public Ladder(int height, int numberOfPerson) {
        // 여기 입력 예외 처리하기
        if(height<0||numberOfPerson<0) {
            throw new ArrayIndexOutOfBoundsException("0보다 커야함");
        }
        ladder = new int[numberOfPerson][height];
        ladderPosition= new Position(numberOfPerson,height);
    }
    //TODO:일하기
    public void drawLine(Position p){
        //포지션이 합당한지 확인해야지
        if(Position.LessThenZero(p)){
            return;
        }
        if(impossibleLine(p)){
            return;
        }
        if(!canLine(p)) {
            return;
        }
        ladder[p.x][p.y]=1;
        ladder[p.x+1][p.y]=-1;
    }

    public boolean canLine(Position p){
        if(hasLine(p)){// 이미 그려져 있음
            return false;
        }
        return canMove(p);
    }

    public boolean canMove(Position p){
        Position LeftLine = new Position(p.x-1,p.y);
        Position RightLine = new Position(p.x+1,p.y);
        if(!Position.LessThenZero(LeftLine) && hasLine(LeftLine)){
            return false;
        }
        return Position.LessThenZero(RightLine) || !hasLine(RightLine);
    }
    public boolean hasLine(Position p){
        return ladder[p.x][p.y]!=0;
    }

    public boolean impossibleLine(Position p){
        return p.x >= ladderPosition.x || p.y >= ladderPosition.y-1;
    }

    public int run(int number){
        if(!CanRun(number)){
            return -1;
        }
        return Move(number-1,0)+1;
    }
    public boolean CanRun(int number){
        return number > 0 && number <= ladderPosition.x;
    }

    private int Move(int number, int height){
        if(height>=ladderPosition.y){
            return number;
        }
        else{
            return Move(number+ladder[number][height],height+1);
        }
    }


}
