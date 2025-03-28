package ladder;

// 사다리에 좌표를 표현하는 클래스
public class Position {
    private final int x;
    private final int y;

    // 좌표를 입력받아 생성
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 왼쪽 위치 반환 (x-1, y)
    public Position left() {
        return new Position(x - 1, y);
    }

    // 오른쪽 위치 반환 (x+1, y)
    public Position right() {
        return new Position(x + 1, y);
    }

    // HashSet의 중복 체크(재정의해둬야 컬렉션에서 정상 동작)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // 자기 자신
        if (obj == null || getClass() != obj.getClass()) return false; // 타입 체크

        Position position = (Position) obj;
        return x == position.x && y == position.y; // 좌표 값이 같으면 같은 객체로 판단
    }

    @Override
    public int hashCode() {
        return 31 * x + y; // 해시코드 계산
    }
    /*
    hashCode()란?
    hashCode()는 객체를 해시 자료구조(HashSet, HashMap, HashTable)에 넣을 때 내부에서 사용하는 값
    equals()로만 비교하면 속도가 느려서  hashCode()로 후보를 줄이고, 이후에 equals()로 정확하게 비교
    => hashCode()는 객체의 고유한 숫자값(해시값) 을 반환하는 함수
    [31 * x + y]식을 사용하는 이유?
    해시값 생성의 목표 → Position(x, y)의 값 조합으로 최대한 중복이 적고 고르게 분포된 값 생성
    → 31은 소수라 곱했을 때 해시 충돌(같은 해시값이 나오는 상황)을 줄이는 데 효과적
    → 또한, 컴퓨터에서 31 * x == (x << 5) - x 로 빠르게 계산할 수 있어서 전통적으로 사용

    ex) hash = 31 * x + y
    → x와 y의 값을 조합해 하나의 고유한 정수값으로 변환
    → (2,3)과 (3,2)는 서로 다른 해시값이 나옴
    → 31 * 2 + 3 = 65
    → 31 * 3 + 2 = 95
    */
}
