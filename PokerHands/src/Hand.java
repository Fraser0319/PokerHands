import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

	public handRankings checkFlush(ArrayList<Card> hand) {
		String suit = hand.get(0).getSuit();
		int suitCount = 0;
		HashMap<cardValue, String> tempMap = new HashMap<cardValue, String>();
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

		Map<cardValue, Integer> freqMap = new HashMap<cardValue, Integer>();

		for (Card c : hand) {
			if (freqMap.containsKey(c.getValue())) {
				freqMap.put(c.getValue(), freqMap.get(c.getValue()) + 1);
			} else {
				freqMap.put(c.getValue(), 1);
			}
		}
		System.out.println(freqMap.entrySet());

		Set<Integer> fullHouseCheck = new HashSet<Integer>(freqMap.values());

		System.out.println("set output: " + fullHouseCheck);
		if (freqMap.containsValue(4)) {
			return handRankings.fourOfAKind;

		} else if (fullHouseCheck.contains(2) && fullHouseCheck.contains(3)) {
			return handRankings.fullHouse;
		}

		else if (freqMap.containsValue(3)) {
			return handRankings.threeOfAKind;
		}

		if (Collections.frequency(freqMap.values(), 2) == 2) {
			return handRankings.twoPairs;
		}

		if (freqMap.containsValue(2)) {
			return handRankings.onePair;
		}

		return handRankings.highCard;
	}

	public handRankings checkStraight(ArrayList<Card> hand) {

		ArrayList<cardValue> straightList = new ArrayList<cardValue>();
		int count = 0;
		int j = 0;
		for (Card c : hand) {
			straightList.add(c.getValue());
		}
		Collections.sort(straightList);

		for (int i = 0; i < 4; i++) {
			if (straightList.get(j + 1).showValue() == straightList.get(i).showValue() + 1) {
				count++;
				j++;
			}

		}
		if (count == 4) {
			return handRankings.Straight;
		}

		return handRankings.fail;
	}

	@Override
	public String toString() {
		return hand.toString();
	}

}
