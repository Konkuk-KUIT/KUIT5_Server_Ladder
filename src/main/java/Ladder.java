import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Row> rows;
    private final NaturalNumber numberOfPerson;
    private final NaturalNumber countRandomLine;

    private Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
        this.rows = IntStream.range(0, row.getNumber())
                .mapToObj(i -> new Row(numberOfPerson.getNumber()))
                .collect(Collectors.toList());
        this.countRandomLine = toNaturalNumber(row.getNumber() * numberOfPerson.getNumber());
    }
    public static Ladder create(int row, int numberOfPerson){
        return new Ladder(toNaturalNumber(row), toNaturalNumber(numberOfPerson));
    }

    public void drawLine(int line, int level) {
        // 자연수인지 검증.
        NaturalNumber lineValue = toNaturalNumber(line);
        NaturalNumber levelValue = toNaturalNumber(level);
        // 지정된 높이가 유효한지 검증
        validateLevelIsNotOutOfRange(levelValue);
        rows.get(levelValue.getNumber() - 1).drawLine(lineValue);
    }

    private void validateLevelIsNotOutOfRange(NaturalNumber lineValue) {
        if(lineValue.getNumber() > rows.size()){
            throw new IllegalArgumentException(ExceptionMessage.INVALD_DRAW_POSITION.getMessage());
        }
    }

    public int run(int line) {
        NaturalNumber lineValue = toNaturalNumber(line);
        validateRunLineIsNotOutOfRange(lineValue);
        LadderPosition position = LadderPosition.create(lineValue.getNumber() - 1, 0);

        for(; position.getY() < rows.size(); position = position.moveDown()){
            System.out.println("Before");
            printLadder(position);
            position = position.moveBreadthwise(rows.get(position.getY()).move(position.getX()));
            System.out.println("After");
            printLadder(position);
        }

        return position.getX() + 1;
    }

    private void printLadder(LadderPosition position) {
        for(int levelIndex = 0; levelIndex < rows.size(); levelIndex ++) {
            System.out.println(rows.get(levelIndex).printRow(position.getX(), position.checkY(levelIndex)));
        }
        System.out.println();
    }

    private void validateRunLineIsNotOutOfRange(NaturalNumber lineValue) {
        if(lineValue.getNumber() > numberOfPerson.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALD_POSITION.getMessage());
        }
    }

    private static NaturalNumber toNaturalNumber(int number) {
        return new NaturalNumber(number);
    }

    private void drawRandomLine(){
        NaturalNumber randomLevel, randomLine;
        Random random = new Random();
        for(int count = 0; count<countRandomLine.getNumber(); count ++) {
            randomLine = toNaturalNumber(random.nextInt(numberOfPerson.getNumber()) + 1);
            randomLevel = toNaturalNumber(random.nextInt(rows.size())+1);
            if(randomLine.getNumber() > numberOfPerson.getNumber() - 1 || randomLevel.getNumber() > rows.size()){
                count--;
                continue;
            }
            rows.get(randomLevel.getNumber() - 1).drawLine(randomLine);
        }
    }
}
