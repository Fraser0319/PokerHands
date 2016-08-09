import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Hand {

	private ArrayList<Card> hand = new ArrayList<Card>();

	public Hand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public ArrayList<Card> createHand(String cards) {

		for (String part : cards.split("\\s+")) {
			Card currentCard = new Card(part);
			hand.add(currentCard);
		}
		hand.removeAll(hand);
		return hand;
	}

	// public handRankings rankHand(ArrayList<Card> hand) {
	//
	// }

	public handRankings checkFlush(ArrayList<Card> hand) {
		String suit = hand.get(0).getSuit();
		int suitCount = 0;
		HashMap<String, String> tempMap = new HashMap<String, String>();
		for (Card c : hand) {
			tempMap.put(c.getValue(), c.getSuit());
		}
		for (String s : tempMap.values()) {
			if (s.equals(suit)) {
				suitCount++;
			}
		}
		if (suitCount == 5) {
			return handRankings.Flush;
		}

		return handRankings.fail;
	}

	public handRankings checkPair(ArrayList<Card> hand) {

		HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
		for (Card c : hand) {
			if (tempMap.containsKey(c.getValue())) {
				tempMap.put(c.getValue(), tempMap.get(c.getValue()) + 1);
			} else {
				tempMap.put(c.getValue(), 1);
			}
		}

		if (tempMap.containsValue(4)) {
			return handRankings.fourOfAKind;

		} else if (tempMap.containsValue(3)) {
			return handRankings.threeOfAKind;

		} else if (tempMap.containsValue(2)) {
			return handRankings.onePair;
		}
		return handRankings.fail;
	}

	@Override
	public String toString() {
		return hand.toString();
	}

}
