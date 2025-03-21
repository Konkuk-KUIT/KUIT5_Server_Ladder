public class Row {

    private final Node[] nodes;

    public Row(int numberOfPeople) {
        this.nodes = new Node[numberOfPeople];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Node.of(0);
        }
    }

    public void drawLineOnNode(Position position) {
        nodes[position.getValue()].setRight();
        position.moveRight();
        nodes[position.getValue()].setLeft();
    }

    //test코드 용 state 반환 메서드
    public int getState(Position position) {
        return nodes[position.getValue()].getState();
    }

}
