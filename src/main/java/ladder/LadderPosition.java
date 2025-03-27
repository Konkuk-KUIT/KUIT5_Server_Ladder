package ladder;

// * 표시를 해야 하는 x, y 좌표의 유효성을 담당하는 클래스
public class LadderPosition {
    private final int x;
    private final int y;

    public LadderPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static LadderPosition of(int x, int y) {
        return new LadderPosition(x, y);
    }

    //같은 포지션인지
    public boolean isInARightPosition(int x, int y) {
        return this.x == x && this.y == y;
    }
}
