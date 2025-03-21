public class Row {

    private final Node[] nodes;

    public Row(int numberOfPeople) {
        this.nodes = new Node[numberOfPeople];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Node.of(0);
        }
    }

    public void drawLineOnNode(Position position) {
        // 입력 검사
        if (!validateDrawPosition(position)) return;

        nodes[position.getValue()].setRight();
        position.moveRight();
        nodes[position.getValue()].setLeft();
    }

    private boolean validateDrawPosition(Position position){
        if (position.getValue()<0 || position.getValue()>=nodes.length-1){
            throw new IllegalArgumentException("잘못된 사다리 위치입니다.");
        }
        return true;
    }

    public void move(Position start){
        // 입력 검사
        if (!validateStartPosition(start)) return ;

        nodes[start.getValue()].moveColumn(start);
    }

    //시작위치가 적절한지 확인
    private boolean validateStartPosition(Position position){
        if (position.getValue()<0 || position.getValue()>=nodes.length){
            throw new IllegalArgumentException("잘못된 시작 위치입니다.");
        }
        return true;
    }

    //test코드 용 state 반환 메서드
    public int getState(Position position) {
        return nodes[position.getValue()].getState();
    }

}
