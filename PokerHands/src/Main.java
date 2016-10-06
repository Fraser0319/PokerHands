import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {

		Main m = new Main();
		m.parseHands();

	}

	public void parseHands() {
		int p1wins = 0;
		int p2wins = 0;

		try {
			for (String line : Files.readAllLines(Paths.get("poker.txt"))) {

				Hand hand1 = new Hand(line.substring(0, 14));
				Hand hand2 = new Hand(line.substring(14, 29).trim());

				HandRankings result1 = hand1.evaluateHand(hand1.getHand());
				HandRankings result2 = hand2.evaluateHand(hand2.getHand());
				
				// checking a pair or higher set hand
				int pairValue1 = hand1.getHigherSet(hand1.getHand()).value;
				int pairValue2 = hand2.getHigherSet(hand2.getHand()).value;
				
				// finding the highest value card in the hand
				int highCardValue1 = hand1.getHighestCardValue(hand1.getHand());
				int highCardValue2 = hand2.getHighestCardValue(hand2.getHand());

				if (result1 == result2) {
					if (result1 == HandRankings.onePair
							|| result1 == HandRankings.twoPairs
							|| result1 == HandRankings.threeOfAKind
							|| result1 == HandRankings.fourOfAKind) {
						if (pairValue1 > pairValue2) {
							p1wins++;
							System.out.println("player 1 wins\n" + hand1.toString() + " " + result1);
						} else {
							p2wins++;
							System.out.println("player 2 wins\n"+ hand2.toString() + " " + result2);
						}
					} else {
						if (highCardValue1 > highCardValue2) {
							p1wins++;
							System.out.println("player 1 wins\n" + hand1.toString() + " " + result1);
						}
					}

				} else {

					if (result1.value > result2.value) {
						p1wins++;
						System.out.println("player 1 wins\n" + hand1.toString() + " " + result1);
					} else {
						p2wins++;
						System.out.println("player 2 wins\n" + hand2.toString() + " " + result2);
					}
				}
			}
			System.out.println("\n" + p1wins);
			System.out.println("\n" + p2wins);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
