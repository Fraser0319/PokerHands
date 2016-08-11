import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hand {

	private List<cardValue> broadwayList = Arrays.asList(cardValue.A,
			cardValue.T, cardValue.J, cardValue.K, cardValue.Q);
	private List<cardValue> wheelList = Arrays.asList(cardValue.A,
			cardValue.Two, cardValue.Three, cardValue.Four, cardValue.Five);
	private ArrayList<Card> handList = new ArrayList<Card>();

	String hand;

	public ArrayList<Card> getHand() {
		return handList;
	}

	public Hand(String hand) {
		this.hand = hand;
		createHand(hand);
	}

	public void createHand(String cards) {
		handList.removeAll(handList);
		for (String part : cards.split("\\s+")) {
			Card currentCard = new Card(part);
			handList.add(currentCard);
		}
	}

	public int getHighestCardValue(ArrayList<Card> hand) {
		ArrayList<cardValue> cardValues = new ArrayList<cardValue>();
		for (Card c : hand) {
			cardValues.add(c.getValue());
		}
		cardValue maxCard = Collections.max(cardValues);
		return maxCard.value;
	}

	public cardValue getHigherSet(ArrayList<Card> hand) {
		Map<cardValue, Integer> freqMap = checkFrequency(hand);
		for (Map.Entry<cardValue, Integer> e : freqMap.entrySet()) {
			cardValue card = e.getKey();
			int freq = e.getValue();

			switch (freq) {
			case 2:
				return card;
			case 3:
				return card;
			case 4:
				return card;
			}
		}

		return cardValue.fail;
	}

	@Override
	public String toString() {
		return this.hand.toString();
	}

	public Map<cardValue, Integer> checkFrequency(ArrayList<Card> hand) {

		Map<cardValue, Integer> freqMap = new HashMap<cardValue, Integer>();

		for (Card c : hand) {
			if (freqMap.containsKey(c.getValue())) {
				freqMap.put(c.getValue(), freqMap.get(c.getValue()) + 1);
			} else {
				freqMap.put(c.getValue(), 1);
			}
		}
		return freqMap;
	}

	public boolean checkFlush(ArrayList<Card> hand) {
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
			return true;
		}
		return false;
	}

	public boolean checkPair(ArrayList<Card> hand) {

		Map<cardValue, Integer> freqMap = checkFrequency(hand);

		if (freqMap.containsValue(2)) {
			return true;
		}
		return false;

	}

	public boolean checkTwoPair(ArrayList<Card> hand) {
		Map<cardValue, Integer> freqMap = checkFrequency(hand);

		if (Collections.frequency(freqMap.values(), 2) == 2) {
			return true;
		}

		return false;
	}

	public boolean checkThreeOfAKind(ArrayList<Card> hand) {

		Map<cardValue, Integer> freqMap = checkFrequency(hand);

		if (freqMap.containsValue(3)) {
			return true;
		}

		return false;
	}

	public boolean checkFourOfAKind(ArrayList<Card> hand) {
		Map<cardValue, Integer> freqMap = checkFrequency(hand);

		if (freqMap.containsValue(4)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkFullHouse(ArrayList<Card> hand) {
		Map<cardValue, Integer> freqMap = checkFrequency(hand);

		Set<Integer> fullHouseCheck = new HashSet<Integer>(freqMap.values());
		System.out.println(freqMap.keySet());
		if (fullHouseCheck.contains(2) && fullHouseCheck.contains(3)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkStraight(ArrayList<Card> hand) {

		ArrayList<cardValue> straightList = new ArrayList<cardValue>();
		int count = 0;
		int j = 0;
		for (Card c : hand) {
			straightList.add(c.getValue());
		}
		Collections.sort(straightList);
		if (straightList.containsAll(wheelList)) {
			return true;
		}
		for (int i = 0; i < 4; i++) {
			if (straightList.get(j + 1).showValue() == straightList.get(i)
					.showValue() + 1) {
				count++;
				j++;
			}

		}
		if (count == 4) {
			return true;
		}
		return false;
	}

	public boolean checkStraightFlush(ArrayList<Card> hand) {

		if (checkFlush(hand) == true && checkStraight(hand) == true) {
			return true;
		}
		return false;
	}

	public boolean checkRoyalFlush(ArrayList<Card> hand) {
		ArrayList<cardValue> valueList = new ArrayList<cardValue>();

		if (checkFlush(hand) == true) {
			for (Card c : hand) {
				valueList.add(c.getValue());
			}
			if (valueList.containsAll(broadwayList)) {
				return true;
			}
		}
		return false;
	}

	public handRankings evaluateHand(ArrayList<Card> hand) {

		if (checkRoyalFlush(hand)) {
			return handRankings.royalFlush;

		} else if (checkStraightFlush(hand)) {
			return handRankings.straightFlush;

		} else if (checkFourOfAKind(hand)) {
			return handRankings.fourOfAKind;

		} else if (checkFullHouse(hand)) {
			return handRankings.fullHouse;

		} else if (checkFlush(hand)) {
			return handRankings.Flush;

		} else if (checkStraight(hand)) {
			return handRankings.Straight;

		} else if (checkThreeOfAKind(hand)) {
			return handRankings.threeOfAKind;

		} else if (checkTwoPair(hand)) {
			return handRankings.twoPairs;

		} else if (checkPair(hand)) {
			return handRankings.onePair;
		} else {
			return handRankings.highCard;
		}

	}

}
