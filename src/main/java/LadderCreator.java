public interface LadderCreator {
    Row[] getRows();
    Direction getState(Position row, Position col);
    void drawLine(Position row, Position col);
}
// 추상클래스 어떤데 -> 걍 인터페이스 둬봐