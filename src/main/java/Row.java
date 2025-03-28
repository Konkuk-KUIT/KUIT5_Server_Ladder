import java.util.List;

public class Row {

    private final List<Boolean> points;

    public Row(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public LadderPosition move(LadderPosition position) {
        int x = position.getX();
        Direction direction = getDirectionAt(x);

        if (direction == Direction.LEFT) {
            return position.moveLeft();
        } else if (direction == Direction.RIGHT) {
            return position.moveRight();
        }
        return position.moveDown();  // 수직 이동
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("|");
        for (boolean point : points) {
            if (point) {
                sb.append("-----|");
            } else {
                sb.append("     |");
            }
        }
        return sb.toString();
    }

    public Direction getDirectionAt(int x) {
        boolean left = x > 0 && points.get(x - 1);
        boolean right = x < points.size() - 1 && points.get(x);
        return Direction.of(left, right);
    }

    private void validateDrawPosition(int x) {
        if (x > 0 && points.get(x - 1)) {
            throw new IllegalArgumentException(ErrorCode.DISALLOWED_CONTINUOUS_LINE.getErrorMessage());
        }
        if (x < points.size() - 1 && points.get(x + 1)) {
            throw new IllegalArgumentException(ErrorCode.DISALLOWED_CONTINUOUS_LINE.getErrorMessage());
        }
        if (points.get(x)) {
            throw new IllegalArgumentException(ErrorCode.LINE_ALREADY_EXISTS.getErrorMessage());
        }
    }
    // 선을 그리는 메서드 추가
    public void drawLine(int position) {
        if (position < 0 || position >= points.size()) {
            throw new IllegalArgumentException("선 그리기 위치가 범위를 벗어났습니다.");
        }
        points.set(position, true);  // 해당 위치에 선을 그림
    }

}
