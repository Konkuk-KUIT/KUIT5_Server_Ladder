public class NaturalNumber {
    private final int number;
    public NaturalNumber(int number){
        validateNumberIsNatural(number);
        this.number = number;
    }

    private void validateNumberIsNatural(int number) {
        if(number < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALD_NATURAL_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
