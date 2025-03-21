import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int size) {
        this.points = new ArrayList<>(Collections.nCopies(size,false));
    }

    public void draw(int x) {
        validateDrawPosition(x);
        points.set(x, true);
    }

    public Direction getDirectionAt(int x){
        boolean left = x > 0 && points.get(x-1);
        boolean right = x < points.size()-1 && points.get(x);
        return Direction.of(left,right);
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

    public int size() {
        return points.size();
    }
}