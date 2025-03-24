public class Positions {
    private Position[][] positions;

    public Positions(int row, int col) {
        initializePositions(row, col);
    }

    private void initializePositions(int row, int col) {
        positions = new Position[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                positions[i][j] = new Position();
            }
        }
    }

    public Position[][] getPositions(){
        return this.positions;
    }

    public Position getPosition(int row, int col){
        return this.positions[row][col];
    }

    public int getMaxRow(){
        return positions.length;
    }

    public int getMaxCol(int row){
        return positions[row].length;
    }

    public int getMaxCol(){
        return positions[0].length;
    }
}
