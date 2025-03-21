import java.util.Arrays;

public class Ladder {
    private int[][] ladderArray;

    public Ladder(int height, int memberNum) { // -> paramiterized
        if (height < 1 || memberNum < 1) {
            throw new IllegalArgumentException("행과 열의 크기는 1 이상이어야 합니다");
        }
        this.ladderArray = new int[height][memberNum];
        // 빈 사다리 생성
        initLadderArray();
    }

    private void initLadderArray() {
        for (int[] row : this.ladderArray) Arrays.fill(row, 0);
    }

    public void drawLine(Position pos) { // -> paramiterized
        if (isNotInDrawArange(pos.getRow(), pos.getCol())) {
            throw new IllegalArgumentException("(0 ~ 사다리높이-1), (0 ~ 인원수-2) 범위의 값을 입력하세요.");
        }
        // 양옆체크
        if (this.ladderArray[pos.getRow()][pos.getCol()] == 0 && this.ladderArray[pos.getRow()][pos.getCol() + 1] == 0) {
            this.ladderArray[pos.getRow()][pos.getCol()] = 1;
            this.ladderArray[pos.getRow()][pos.getCol() + 1] = -1;
            System.out.println("사다리의 다리가 성공적으로 추가되었습니다");
            return;
        }
        System.out.println("바로 옆에 다리를 추가할 수 없습니다.");
    }

    private boolean isNotInDrawArange(int row, int col) {
        if (row < 0 || row > this.ladderArray.length - 1) {
            System.out.println("0 ~ 사다리높이-1 까지의 범위를 입력하세요");
            return true;
        }
        if (col < 0 || col > this.ladderArray[0].length - 2) {
            System.out.println("0 ~ 인원수-2 까지의 범위를 입력하세요");
            return true;
        }
        return false;
    }

    public int run(int ladderChoice) {
        if (ladderChoice < 0 || ladderChoice > this.ladderArray[0].length - 1) return -1;
        int nowRow = 0;
        int value;
        Position newPosition = new Position(nowRow, ladderChoice);
        while (newPosition.getRow() != this.ladderArray.length - 1) {
            value = this.ladderArray[newPosition.getRow()][newPosition.getCol()];
            newPosition = decideDirection(value, newPosition);
        }
        System.out.println(newPosition.getCol() + "번 사다리 도착");
        return newPosition.getCol();
    }

    private Position decideDirection(int value, Position position) {
        int nextCol = position.getCol();
        return switch (value) {
            case 0 -> position.moveDown();
            case 1 -> (nextCol >= 0) ? position.moveRight() : position;
            case -1 -> (nextCol <= ladderArray[0].length - 1) ? position.moveLeft() : position;
            default -> position;
        };
    }

    public void printLadderArray() {
        for (int i = 0; i < this.ladderArray.length; i++) {
            for (int j = 0; j < this.ladderArray[0].length; j++) {
                System.out.print(this.ladderArray[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] getLadderArray() {
        return Arrays.stream(ladderArray)
                .map(int[]::clone) // 깊은 복사로 원본 보호
                .toArray(int[][]::new);
    }
}
