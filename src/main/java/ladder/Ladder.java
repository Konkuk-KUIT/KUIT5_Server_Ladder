package ladder;

public class Ladder {
    // 사다리게임 규칙
    // 1. 라인은 같은 행의 좌우로 인접한 위치에만 그을 수 있다.
    // 2. 한 위치에서 좌, 우로 모두 라인을 그을 수 없다.
    // 3. drawLine의 입력은 라인을 긋는 시작 위치와 방향으로 주어진다고 가정한다.

    private final int[][] ladder;
    // 각 위치에서 라인이 없는 경우 0, 왼쪽으로 꺾는 경우 1, 오른쪽으로 꺾는 경우 -1을 저장한다.

    public Ladder(int height, int numberOfPerson) {
        ladder = new int[height+1][numberOfPerson+1];
    }
    // test용 ladder getter
    public int[][] getLadder() {
        return ladder;
    }

    public void drawLine(Position position){
        position.validatePosition(ladder.length, ladder[0].length); // position 값 자체 유효성 검증
        validateLine(position);     // 2번 규칙 유효성 검증

        int row = position.getRow();
        int col = position.getCol();
        int value = position.getValue();

        ladder[row][col] = value;
        if(value==1){
            ladder[row][col-1] = -1;
        }else if(value==-1){
            ladder[row][col+1] = 1;
        }
    }

    private void validateLine(Position position){
        int row = position.getRow();
        int col = position.getCol();
        int value = position.getValue();

        if(ladder[row][col]!=0 || value==1 && ladder[row][col-1]!=0 || value==-1 && ladder[row][col+1]!=0)
            throw new IllegalArgumentException("해당 위치에 이미 라인이 존재합니다.");
    }

    public int run(int num){
        return traverse(1,num,0);
    }

    private int traverse(int row, int col, int value){
        // value는 이 메소드를 호출한 위치의 값 (어디로부터 왔는지를 의미)
        if(row==ladder.length)
            return col;

        if(ladder[row][col]==1 && value!=-1)
            return traverse(row, col-1, 1);
        else if(ladder[row][col]==-1 && value!=1)
            return traverse(row, col+1, -1);
        else
            return traverse(row+1, col, 0);
    }
}