public class Node {
    private int state;

    private Node(int state){
        this.state=state;
    }

    public static Node of(int state){
        return new Node(state);
    }

    public int getState(){
        return this.state;
    }

    public void setRight(){
        //todo parser 위치
        this.state=1;

    }
    public void setLeft(){
        //todo parser 위치
        this.state=-1;
    }

    private boolean checkVailed(){
        if (this.state==0){
            return true;
        }
        //예외 발생 :올바르지 않은 위치
        return false;
    }
    //todo parser 정의 위치

}
