public class LadderInfo {

    private final int numberOfMember;
    private final int height;

    public int getNumberOfMember() {
        return numberOfMember;
    }

    public int getHeight() {
        return height;
    }

    public LadderInfo(int numberOfMember, int height) {
        validateLadderInfo(numberOfMember, height);
        this.numberOfMember = numberOfMember;
        this.height = height;
    }

    private static void validateLadderInfo(int numberOfMember, int height){
        if(numberOfMember < 1){
            throw new IllegalArgumentException("사람 수는 1 이상이어야 합니다.");
        }
        if(height < 1){
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

}
