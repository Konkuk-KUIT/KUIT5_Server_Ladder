package ladder.LadderGame;

import ladder.exception.ExceptionMessage;

public class Ladder {

    private Row[] rows;

    private Ladder(Positive numberOfPerson, Positive height){

        validateCreateLadder(numberOfPerson, height);

        rows = new Row[height.getNumber()+1];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = Row.of(numberOfPerson);
        }
    }

    public static Ladder of(Positive numberOfPerson, Positive height){
        return new Ladder(numberOfPerson, height);
    }


    public void drawLine(int line, int height){
        validateDrawHeight(height);
        rows[height].drawLine(line);
    }


    public int run(int startLine){

        int nowLine = startLine;

        for (int nowHeight = 1; nowHeight < rows.length; nowHeight++) {

            printBeforeState(nowLine, nowHeight);
            nowLine += rows[nowHeight].move(nowLine);
            printAfterState(nowLine, nowHeight);

        }

        return nowLine;
    }


    public void printBeforeState(int nowLine, int nowHeight){
        System.out.println("Before");
        printLadder(nowLine, nowHeight);

    }

    public void printAfterState(int nowLine, int nowHeight) {
        System.out.println("After");
        printLadder(nowLine, nowHeight);
    }

    private void printLadder(int nowLine, int nowHeight) {
        for (int printingRow = 1; printingRow < rows.length; printingRow++) {
            printRow(nowLine, nowHeight, printingRow);
        }
    }

    private void printRow(int nowLine, int nowHeight, int printingRow) {
        if(nowHeight == printingRow){
            rows[printingRow].printRowWithCurrentPosition(nowLine);
        }
        if(nowHeight != printingRow){
            rows[printingRow].printRowWithOutCurrentPosition(nowLine);
        }
    }


    private void validateCreateLadder(Positive numberOfMember, Positive height){

        if(numberOfMember.getNumber() < 2 || height.getNumber() < 2){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());
        }
    }

    private void validateDrawHeight(int height){

        if(height < 1 || rows.length - 1 < height){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }


}
