public class Ladder {

    private final int[][] ladder;
    private final Position ladderPosition;

    public Ladder(int height, int numberOfPerson) {
        // 여기 입력 예외 처리하기
        ladder = new int[numberOfPerson][height];
        ladderPosition= new Position(numberOfPerson,height);
    }

    public void drawLine(Position p){
        //포지션이 합당한지 확인해야지
        if(Position.LessThenZero(p)){
            return;
        }
        if(ImpossibleLine(p)){
            return;
        }
        if(!CanLine(p)){
            return;
        }
        ladder[p.x][p.y]=1;
        ladder[p.x+1][p.y]=-1;

    }

    public boolean CanLine(Position p){
        if(HasLine(p)){// 이미 그려져 있음
            return false;
        }
        return CanMove(p);
    }

    public boolean CanMove(Position p){
        Position LeftLine = new Position(p.x-1,p.y);
        Position RightLine = new Position(p.x+1,p.y);
        if(!Position.LessThenZero(LeftLine) && HasLine(LeftLine)){
            return false;
        }
        return ImpossibleLine(RightLine) || !HasLine(RightLine);
    }
    public boolean HasLine(Position p){
        return ladder[p.x][p.y]!=0;
    }

    public boolean ImpossibleLine(Position p){
        return p.x >= ladderPosition.x || p.y >= ladderPosition.y;
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
