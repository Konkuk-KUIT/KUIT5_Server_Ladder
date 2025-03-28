package StringCalculator;

public enum Separator {
    COMMA(","),
    COLON(":");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public static String makeRegularExpression() {
        StringBuilder sb = new StringBuilder();
        for (Separator separator : Separator.values()) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append(separator.separator);
        }
        return sb.toString();
    }
}
