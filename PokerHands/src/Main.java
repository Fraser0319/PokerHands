
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Main m = new Main();
		m.parseHands();

	}

	public void parseHands() {

		// ArrayList<String> parsedHand1 = new ArrayList<String>();
		// ArrayList<String> parsedHand2= new ArrayList<String>();
		int p1wins = 0;
		int p2wins = 0;

		try {
			for (String line : Files.readAllLines(Paths.get("poker.txt"))) {

				Hand hand1 = new Hand(line.substring(0, 14));
				Hand hand2 = new Hand(line.substring(14, 29).trim());

				handRankings result1 = hand1.evaluateHand(hand1.getHand());
				handRankings result2 = hand2.evaluateHand(hand2.getHand());

				if (result1.value > result2.value) {
					p1wins++;
					System.out.println("player 1 wins\n" + hand1.toString() + " " + result1);
				} else {
					p2wins++;
					System.out.println("player 2 wins\n" + hand2.toString() + " " + result2);
				}
			}
			System.out.println("\n"+p1wins);
			System.out.println("\n"+p2wins);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
