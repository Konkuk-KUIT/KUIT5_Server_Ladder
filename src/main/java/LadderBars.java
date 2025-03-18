public class LadderBars {

    //가로선을 2차원 배열로 저장
    //bars[i][j] = true 일 시, i번, i+1번 막대 사이 j 높이에 가로선이 있음
    private boolean[][] bars;

    public LadderBars(final int numberOfMember, final int height){
        bars = new boolean[numberOfMember+1][height+1];
    }

    //가로선 추가
    public void drawBar(final int line, final int height){
        validateDrawPosition(line, height);
        bars[line][height] = true;
    }

    //실행 결과
    public int run(final int startLine){

        validateRunPosition(startLine);

        int nowLine = startLine;
        int nowHeight = 1;

        while(nowHeight < bars[0].length){
            nowLine = getNextLine(nowLine, nowHeight);
            nowHeight++;
        }

        return nowLine;
    }

    private int getNextLine(final int line, final int height){
        if(bars[line-1][height]) return line-1;
        if(bars[line][height]) return line+1;
        return line;
    }

    private void validateDrawPosition(final int line, final int height){
        if(line < 1 || bars.length - 2 < line){
            throw new IllegalArgumentException("해당 위치에는 사다리를 둘 수 없습니다.");
        }
        if(height < 1 || bars[0].length - 1 < height){
            throw new IllegalArgumentException("해당 위치에는 사다리를 둘 수 없습니다.");
        }
        if(bars[line-1][height] || bars[line][height] || bars[line+1][height]){
            throw new IllegalArgumentException("해당 위치에는 사다리를 둘 수 없습니다.");
        }
    }

    private void validateRunPosition(final int line){
        if(line < 1 || bars.length - 1 < line){
            throw new IllegalArgumentException("해당 위치에서는 시작할 수 없습니다.");
        }
    }

}
