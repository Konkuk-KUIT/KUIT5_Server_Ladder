package ladder;

public class Position {
    private final int row;
    private final int col;
    private final int value;  // 라인이 없는 경우 0, 왼쪽으로 꺾어야 하는 경우 1, 오른쪽으로 꺾어야 하는 경우 -1

    public Position(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public int getValue() {
        return value;
    }

    public void validatePosition(int height, int width){
        if(this.col<=0 || this.row<=0 || this.row>=height || this.col>=width)
            throw new IllegalArgumentException("사다리의 범위를 벗어난 입력입니다.");
        if(this.value==1 && this.col==1 || this.value==-1 && this.col==width-1)
            throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");
        if(this.value!=1 && this.value!=-1)
            throw new IllegalArgumentException("방향값 오류입니다.");
    }
}
