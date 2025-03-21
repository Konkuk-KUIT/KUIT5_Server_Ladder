public class Ladder {

    private final int[][] rows;
    private final Number row;
    private final Number numberOfPerson;

    public void drawCheck(Position position){
        if(position.getX()<=0 || position.getX()>=row.getNumber()+1 || position.getY()-1<0 || position.getY()-1>numberOfPerson.getNumber()-1){
            throw new IllegalArgumentException("Out of range x : 1 ~ "+row.getNumber()+" y : 0~"+(numberOfPerson.getNumber()-1));
        }
    }
    public Ladder(Number row, Number numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
        this.row = row;
        rows = new int[row.getNumber()+2][numberOfPerson.getNumber()];
        for(int i=0; i<numberOfPerson.getNumber(); i++){
            rows[row.getNumber()+1][i] = 2;
        }
    }

    public void drawLine(Position position){
        drawCheck(position);
        rows[position.getX()][position.getY()-1] = 1;
    }
    public int run(Number user){
        // user의 위치 -> position 객체
        Position position = new Position(0,user.getNumber()-1);
        while(true){
            //TODO : 사다리타고 아래로 한 칸 내려가는 함수
            position.goDown();
            //배열을 가지고 있는 객체가 있으면 좋을것 같다. user?
            if(isEnd(rows,position)==true){
                break;
            }
            position.setY(isBridge(rows, position.getX(), position.getY()));
        }
        // 유저의 도착 번호 반환
        return position.getY()+1;
    }
    public boolean isEnd(int[][] rows, Position position){
        if(rows[position.getX()][position.getY()]==2){
            return true;
        }
        return false;
    }
    public int isBridge(int[][] rows, int x, int y){
        if(rows[x][y]==1){
            y= moveSideWays(rows,x,y);
        }
        return y;
    }
    public int moveSideWays(int[][] rows, int x, int y){
        if(y==0){
            y++;
        }
        else if(y==numberOfPerson.getNumber()-1){
            y--;
        }
        else if(rows[x][y-1]==1){
            y--;
        }
        else if(rows[x][y+1]==1){
            y++;
        }
        return y;
    }
}
