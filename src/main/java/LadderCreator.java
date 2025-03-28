public interface LadderCreator {
    // 라인 생성 전략 인터페이스
    boolean canDrawLine(Ladder ladder, int row, int col);
    void createLines(Ladder ladder);
}
