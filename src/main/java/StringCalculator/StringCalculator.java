package StringCalculator;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(splits(text)));
    }

    private static String[] splits(String text) {
        return text.split(Separator.makeRegularExpression());
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    // 1. String[] -> Positive[] 파싱
    private static Positive[] toInts(String[] values) {
        Positive[] numbers = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = new Positive(values[i]);
        }
        return numbers;
    }

    // 2. numbers 배열에 있는 모든 수를 종합
    private static int sum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers) {
            result = result.add(number);
        }
        return result.getNumber();
    }


}
