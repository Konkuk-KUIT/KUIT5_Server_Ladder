/**
 LadderLine
 -사다리의 세로 줄을 담당하는 클래스.
 -내부에 높이만큼 배열을 만들어 각 줄 row 관리.
 */
public class LadderLine {
    private final int[] line;

    //사다리 높이 및 row 설정
    public LadderLine(int height) {
        if(height <= 0) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
        line = new int[height]; // 기본적으로 0으로 초기화
    }

    public void setRowValue(int row, int value) {
        line[row] = value;
    }

    public int getHeight() {
        return line.length;
    }

    public int getRowValue(int row) {
        return line[row];
    }

}


