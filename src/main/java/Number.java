public class Number {
    private int number;
    public Number(final int number){
        if(number<=0){
            throw new IllegalArgumentException(ExceptionMessage.ONLYNUMBER.getMessage());
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
