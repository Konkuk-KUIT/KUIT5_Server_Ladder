import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<Row> rows;
    private final NaturalNumber numberOfPerson;

    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = IntStream.range(0, row.getValue())
                .mapToObj(i -> Row.create(numberOfPerson.getValue()))
                .collect(Collectors.toList());
        this.numberOfPerson = numberOfPerson;
    }

    public static Ladder create(int row, int numberOfPerson) {
        return new Ladder(NaturalNumber.of(row), NaturalNumber.of(numberOfPerson));
    }

    public void drawLine(int line, int level) {
        NaturalNumber validLevel = NaturalNumber.of(level);
        NaturalNumber validLine = NaturalNumber.of(line);
        if(validLevel.getValue() > rows.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LEVEL.getMessage());
        }
        rows.get(validLevel.getValue()-1).drawLine(validLine.getValue());
    }

    public int run(int selectedLine) {
        NaturalNumber line = NaturalNumber.of(selectedLine);

        if (line.getValue() > numberOfPerson.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RUN_LINE.getMessage());
        }

        int currentLine = line.getValue() - 1;

        for (int level = 0; level < rows.size(); level++) {
            currentLine = rows.get(level).move(currentLine);
        }

        return currentLine + 1;
    }

}