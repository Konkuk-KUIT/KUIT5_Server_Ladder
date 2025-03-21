public class LadderRunner {
    public int run(Ladder ladder, int startPosition) {
        Row[] rows = ladder.getRows();

        if(!isValidStartPosition(startPosition, rows[0].getLineStates().length)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }

        for(int i = 0; i < rows.length ; i++){
            switch (rows[i].getLineStates()[startPosition]) {
                case LEFT -> startPosition--;
                case RIGHT -> startPosition++;
            }
        }

        return startPosition;
        // NONE이라면 col 그대로 , row+1
        // LEFT라면 col-1 row +1
        // RIGHT라면 col+1 row +1
    }

    private boolean isValidStartPosition(int startPosition, int numberOfPerson) {
        if(startPosition < 0 || startPosition >= numberOfPerson){
            return false;
        }
        return true;
    }
}

