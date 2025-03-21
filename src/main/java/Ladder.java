public class Ladder {
    private final int[][] ladder;

    Ladder(int[][] ladder) {
        this.ladder = ladder;
    }

    public boolean CanLine(Position p){
        if(hasLine(p)){// 이미 그려져 있음
            return false;
        }
        return canMove(p);
    }

    public boolean impossibleLine(Position p){
        return p.x+1 >= ladder[0].length || p.y >= ladder.length;
    }

    public boolean canMove(Position p){
        Position LeftLine = new Position(p.x-1,p.y);
        Position RightLine = new Position(p.x+1,p.y);
        if(!Position.LessThenZero(LeftLine) && hasLine(LeftLine)){
            return false;
        }
        return impossibleLine(RightLine) || !hasLine(RightLine);
    }


    public boolean hasLine(Position p){
        return ladder[p.y][p.x]!=0;
    }

    public boolean canRun(int number){
       return number > 0 && number <= ladder[0].length;
    }

    public void setLine(Position p){
        ladder[p.y][p.x]=1;
        ladder[p.y][p.x+1]=-1;
    }

    public int getHeight(){
        return ladder.length;
    }

    public int getValue(Position p){
        try{
            return ladder[p.y][p.x];
        }
        catch(Exception e){
            return 0;
        }

    }

}
