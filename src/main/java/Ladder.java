public class Ladder {

//    private final int[][] rows;
//
//    public Ladder(int row, int numberOfPerson) {
//        rows = new int[row][numberOfPerson];
//    }
//
//    public void drawLine(int target_col, int start_row) {
//        // 사다리가 범위 내에 위치하는지
//        if (!parser(target_col, start_row)) return;
//
//        //한 위치에 하나의 연결만
//        if (rows[start_row][target_col] == 0 && rows[start_row][target_col + 1] == 0) {
//            rows[start_row][target_col] = 1;
//            rows[start_row][target_col + 1] = -1;
//        }
//    }
//
//    public int run(int start_col) {
//        // 입력 검사
//        if (!parser(start_col)) return -1;
//
//        int now_row = 0;
//        while (now_row < rows.length) {
//            start_col += rows[now_row][start_col];
//            now_row++;
//        }
//        System.out.println(start_col);//일단 출력은 해볼까
//        return start_col;
//    }
//
//    private boolean parser(int target_col, int start_row) {
//        if (target_col < 0 || target_col >= rows[0].length - 1 || start_row < 0 || start_row >= rows.length) {
//            throw new IllegalArgumentException("잘못된 사다리 위치입니다.");
//        }
//        return true;
//    }
//
//    private boolean parser(int target_col) {
//        if (target_col < 0 || target_col >= rows[0].length) {
//            throw new IllegalArgumentException("잘못된 시작 위치입니다.");
//        }
//        return true;
//    }
}
// 일단 LadderCreator, LadderRunner, enum, 정적팩토리 메서드 이런거 다 무시하고 생각해보면
// 사다리 타기게임에서 필요한 도메인이 뭔지 생각해보면
// 먼저 높이(Row) 객체, 그 높이 안에 있는 각 사다리줄 객체
// 이 두개로 drawLine먼저 구현을 해보면 좋을 것 같아
// drawLine구현하고 그 다음에 사다리 내려가는거 구현하고
// Row, Node, Position 이 정도로만 객체 나누고서 구현 도전해봐
