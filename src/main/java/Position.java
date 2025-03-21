public class Position {

    private int position;

    private Position(int position) {
        this.position=position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public int getValue() {
        return this.position;
    }

    public void moveRight() {
        this.position+=1;
    }

    public void moveLeft() {
        this.position-=1;
    }

}
