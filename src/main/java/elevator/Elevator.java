package elevator;

public class Elevator {
    private int currentFloor;

    public Elevator(){
        this.currentFloor = 1;
    }

    void moveToFloor(final int targetFloor){
        validateFloor(targetFloor);
        this.currentFloor = targetFloor;
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    private void validateFloor(final int targetFloor){
        if(targetFloor < 1 || targetFloor > 10){
            throw new IllegalArgumentException("요청할 층은 1 이상 10 이하의 수만 가능합니다.");
        }
    }
}
