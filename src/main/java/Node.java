public class Node {
    private int state;

    private Node(int state){
        this.state=state;
    }

    public static Node of(int state){
        return new Node(state);
    }

    public void setRight(){
        //todo parser 위치
        this.state=1;
    }

    public void setLeft(){
        //todo parser 위치
        this.state=-1;
    }

    //todo parser 정의 위치
//    private boolean checkVailed(){
//        if (this.state==0){
//            return true;
//        }
//        //예외 발생 :올바르지 않은 위치
//        return false;
//    }

    //test코드 용 state 반환 메서드
    public int getState(){
        return this.state;
    }

}
