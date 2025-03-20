public class Row {

    private final Node[] nodes;

    public Row(int numberOfPeople) {
        this.nodes = new Node[numberOfPeople];
        for (Node node : nodes) {
            node = Node.of(0);
        }
    }

    public void drawLine(Position position) {
        nodes[position.getvalue()].setRight();
        position.moveRight();
        nodes[position.getvalue()].setLeft();

    }

}

// 사다리 타기게임에서 필요한 도메인이 뭔지 생각해보면
// 먼저 높이(Row) 객체, 그 높이 안에 있는 각 사다리줄 객체
// 이 두개로 drawLine먼저 구현을 해보면 좋을 것 같아
// drawLine구현하고 그 다음에 사다리 내려가는거 구현하고
// Row, Node, Position 이 정도로만 객체 나누고서 구현 도전해봐
