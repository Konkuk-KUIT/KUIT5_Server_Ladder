public class Ladder {
    private final int[][] ladder;
    private final int height;
    private final int people;

    public Ladder(int height, int people) {
        if (height < 1 || people < 1) {
            throw new IllegalArgumentException("사람 수와 사다리 높이는 자연수여야 합니다");
        }
        this.height = height;
        this.people = people;
        this.ladder = new int[height][people];
    }

    public void drawLine(int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= people - 1) {
            throw new IllegalArgumentException("잘못된 위치입니다.");
        }

        if (col > 0 && ladder[row][col - 1] == 1) {
            throw new IllegalArgumentException("선을 연속으로 그을 수 없습니다");
        }
        if (col < people - 2 && ladder[row][col + 1] == 1) {
            throw new IllegalArgumentException("선을 연속으로 그을 수 없습니다");
        }

        ladder[row][col] = 1;
        ladder[row][col + 1] = 1;
    }

    public int run(int start) {
        int position = start;
        for (int i = 0; i < height; i++) {
            if (position < people - 1 && ladder[i][position] == 1) { //왼쪽에 선 있는 경우
                position++;
                continue;
            }
            if (position > 0 && ladder[i][position - 1] == 1) { //오른쪽에 선 있는 경우
                position--;
            }
        }
        return position;
    }
}
