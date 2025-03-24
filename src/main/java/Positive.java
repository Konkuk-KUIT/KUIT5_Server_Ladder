public class Positive {
    private int number;

    public Positive(String number) {
        this(Integer.parseInt(number));
    }
    public Positive(int number) {
        this.number = number;
    }

    private static int parseValue(String number) {
        try{
            System.out.println(Direction.UP);
            return Integer.parseInt(number);

        }
        catch(NumberFormatException e) {
            return 0;
        }
    }
}
