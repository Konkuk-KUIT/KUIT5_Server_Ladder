package util;

public class Position {
    // 현재 위치 파악 클래스
    private int index;

    public Position(int index){
        this.index=index;
    }

    public void move(int direction){
        this.index += direction;
    }

    public int getIndex() {
        return index;
    }
}
