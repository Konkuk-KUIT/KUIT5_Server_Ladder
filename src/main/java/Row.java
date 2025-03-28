public class Row {

    private final Node[] nodes;

    private Row(int numberOfPeople) {
        this.nodes = new Node[numberOfPeople];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Node.of(Direction.NONE);
        }
    }

    public static Row of(int numberOfPeople) {
        return new Row(numberOfPeople);
    }

    public void drawLineOnNode(Position position) {
        // 입력 검사
        validateDrawPosition(position);
        //연결될 두 노드가 None인지 검사 (연속으로 이어지는 라인 예외처리)
        validateNodeIsNone(position);
        validateNodeIsNone(Position.of(position.getValue()+1));

        nodes[position.getValue()].setRight();
        position.move(Direction.RIGHT);
        nodes[position.getValue()].setLeft();
    }

    private void validateNodeIsNone(Position position) {
        if (!nodes[position.getValue()].getState().equals(Direction.NONE) ) {
            throw new IllegalArgumentException("잘못된 라인 위치입니다.");
        }
    }

    public void move(Position start){
        // 입력 검사
        validateStartPosition(start) ;
        nodes[start.getValue()].moveColumn(start);
    }

    public StringBuilder rowToString() {
        StringBuilder sb =new StringBuilder();
        for (Node node : nodes) {
            sb.append(String.format("%2s", node.getState().getValue()));
        }
        return sb;
    }

    public void printRow(StringBuilder sb) {
        sb.append(rowToString().toString()).append("\n");
    }


    private void validateDrawPosition(Position position){
        if (validateDrawPositionInList(position)){
            throw new IllegalArgumentException("잘못된 사다리 위치입니다.");
        }
    }

    private boolean validateDrawPositionInList(Position position) {
        return position.getValue() < 0 || position.getValue() >= nodes.length - 1;
    }

    //시작위치가 적절한지 확인
    private void validateStartPosition(Position position){
        if (validateStartPositionInList(position)){
            throw new IllegalArgumentException("잘못된 시작 위치입니다.");
        }
    }

    private boolean validateStartPositionInList(Position position) {
        return position.getValue() < 0 || position.getValue() >= nodes.length;
    }

    //test코드 용 state 반환 메서드
    public Direction getState(Position position) {
        return nodes[position.getValue()].getState();
    }

    public int size() {
        return nodes.length;
    }
}
