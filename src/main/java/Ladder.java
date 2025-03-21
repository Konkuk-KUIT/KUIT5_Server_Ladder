import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final NaturalNumber height, final NaturalNumber numberOfPerson) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < height.getNumber(); i++) {
            lines.add(new Line(numberOfPerson.getNumber() - 1));
        }
    }

    public int run(NaturalNumber startPosition) {
        int position = startPosition.getNumber();
        return move(position) + 1;
    }

    private int move(int position) {
        for (Line line : lines) {
           position += line.getDirectionAt(position).getDirection();
        }
        return position;
    }

    public void drawLine(Position position) {
        validateDrawLine(position);
        lines.get(position.getY()).draw(position.getX());
    }

    private void validateDrawLine(Position position) {
        if (position.getY()>=lines.size()){
            throw new IllegalArgumentException(ErrorCode.OUT_OF_BOUNDS_ROW_POSITION.getErrorMessage());
        }
        if (position.getX()>=lines.get(position.getY()).size()){
            throw new IllegalArgumentException(ErrorCode.OUT_OF_BOUNDS_COL_POSITION.getErrorMessage());
        }
    }
}