public class Main {
        public static void main(String[] args) {
            Ladder ladder = new Ladder(4, 5);

            ladder.drawLine(0, 0);
            ladder.drawLine(1, 1);
//            ladder.drawLine(1, 1);
//            ladder.drawLine(1, 2);

            int result = ladder.run(0);

    }
}
