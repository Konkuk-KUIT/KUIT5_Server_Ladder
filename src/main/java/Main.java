public class Main {
        public static void main(String[] args) {
            Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));

            ladder.drawLine(0, 0);
            ladder.drawLine(1, 1);
//            ladder.drawLine(1, 1);
//            ladder.drawLine(1, 2);

            int result = ladder.run(0);

    }
}
