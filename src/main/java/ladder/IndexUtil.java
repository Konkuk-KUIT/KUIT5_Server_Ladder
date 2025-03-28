package ladder;

public class IndexUtil {

    // 타겟 숫자의 인덱스+1 을 반환함. 즉, *을 삽입할 위치를 반환하는 함수.
    public static int getTokenEndIndex(StringBuilder sb, int tokenIndex) {
        int count = 0;
        int i = 0;

        while (count < tokenIndex && i < sb.length()) {
            if (sb.charAt(i) == ' ') { // 공백 기준 탐색
                count++;
            }
            i++;
        }

        return i + getTokenLength(sb, i);
    }

    // *이 삽입될 정확한 위치를 위해 다음 공백까지의 길이를 구하는 함수 (음수도 존재하기 때문)
    private static int getTokenLength(StringBuilder sb, int startIdx) {
        int len = 0;
        while (startIdx + len < sb.length() && sb.charAt(startIdx + len) != ' ') {
            len++;
        }
        return len;
    }
}
