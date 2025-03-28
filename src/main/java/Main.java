public class Main {
        public static void main(String[] args) {
//            LadderSize size = new LadderSize(new NaturalNumber(4), new NaturalNumber(5));
//            Ladder ladder = new Ladder(size);
//
//            ladder.drawLine(0, 0);
//            ladder.drawLine(1, 1);
////            ladder.drawLine(1, 1);
////            ladder.drawLine(1, 2);
//
//            int result = ladder.run(0);

            LadderSize ladderSize = new LadderSize(new NaturalNumber(4), new NaturalNumber(5));
            LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

            ladderGame.startGame();
            ladderGame.runGame(0);

    }
}
