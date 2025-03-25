package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            beforePresentLadder(new LadderPosition(i, position.getValue()));

            rows[i].nextPosition(position);

            afterPresentLadder(new LadderPosition(i, position.getValue()));
        }
        return position.getValue();
    }




    // Todo 메소드의 내용이 중첩됨
    private void beforePresentLadder(LadderPosition ladderPosition) {
        StringBuilder sb = new StringBuilder();
        sb.append("Before\n");
        for (int i = 0; i<rows.length; i++) {
            sb.append(rows[i].presentNode(i,ladderPosition));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private void afterPresentLadder(LadderPosition ladderPosition) {
        StringBuilder sb = new StringBuilder();
        sb.append("After\n");
        for (int i = 0; i<rows.length; i++) {
            sb.append(rows[i].presentNode(i, ladderPosition));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


}
