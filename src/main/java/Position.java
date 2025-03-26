// 현재 위치를 가지는 클래스
public class Position {
    private int position;
    private Position(int position) {
        this.position=position;
    }
    public static Position of(int position) {
        return new Position(position);
    }
    public void calculatePosition(int toMove){
        this.position+=toMove;
    }
    public int getCurrentPosition(){
        return this.position;
    }

}
