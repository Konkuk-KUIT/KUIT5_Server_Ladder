public class Ladder {

    private final int[][] ladder;
    private final Position ladderPosition;

    public Ladder(int height, int numberOfPerson) {
        ladder = new int[height][numberOfPerson];
        ladderPosition= new Position(numberOfPerson,height);
    }

    public void drawLine(Position p){
        //포지션이 합당한지 확인해야지
        if(!Position.check(p)){
            return;
        }
        if(!PossibleLine(p)){
            return;
        }
        if(!CanLine(p)){
            return;
        }
        if(!CanMove(p)){
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
        Position LeftLine = new Position(ladderPosition.x-1,ladderPosition.y);
        Position RightLine = new Position(ladderPosition.x+1,ladderPosition.y);
        if(!Position.check(LeftLine)){
            return false;
        }
        if(HasLine(LeftLine)){
            return false;
        }
        if(!Position.check(RightLine)){
            return false;
        }
        return !HasLine(RightLine);
    }
    public boolean HasLine(Position p){
        return ladder[p.x][p.y]!=0;
    }

    public boolean PossibleLine(Position p){
        return p.x<ladderPosition.x && p.y<ladderPosition.y;
    }

    public int run(int number){
        return Move(number-1,0);
    }
    private int Move(int number, int height){
        if(height==ladderPosition.y){
            return number;
        }
        else{
            return Move(number+ladder[number][height],height+1);
        }
    }

    public void run(int number){

    }
}
