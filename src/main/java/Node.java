public class Node {
    private int state;

    private Node(int state){
        this.state=state;
    }

    public static Node of(int state){
        return new Node(state);
    }

    public void setRight(){
        this.state=1;
    }

    public void setLeft(){
        this.state=-1;
    }

    public void moveColumn(Position start){
        switch(state){
            case 1 -> start.moveRight();
            case -1 -> start.moveLeft();
        }
    }

    //test코드 용 state 반환 메서드
    public int getState(){
        return this.state;
    }

}
