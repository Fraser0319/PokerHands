import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Hand {

	private List<CardValue> broadwayList = Arrays.asList(CardValue.A,
			CardValue.T, CardValue.J, CardValue.K, CardValue.Q);
	private List<CardValue> wheelList = Arrays.asList(CardValue.A,
			CardValue.Two, CardValue.Three, CardValue.Four, CardValue.Five);
	private List<Card> handList = new ArrayList<Card>();

	String hand;

	public List<Card> getHand() {
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

	public int getHighestCardValue(List<Card> hand) {
		List<CardValue> cardValues = new ArrayList<CardValue>();
		for (Card c : hand) {
			cardValues.add(c.getValue());
		}
		CardValue maxCard = Collections.max(cardValues);
		return maxCard.value;
	}

	public CardValue getHigherSet(List<Card> hand) {
		Map<CardValue, Integer> freqMap = checkFrequency(hand);
		for (Map.Entry<CardValue, Integer> e : freqMap.entrySet()) {
			CardValue card = e.getKey();
			int freq = e.getValue();

			switch (freq) {
			case 2:
			case 3:
			case 4:
				return card;
			}
		}

		return CardValue.fail;
	}

	@Override
	public String toString() {
		return this.hand.toString();
	}

	public Map<CardValue, Integer> checkFrequency(List<Card> hand) {

		Map<CardValue, Integer> freqMap = hand
				.stream()
				.collect(Collectors.groupingBy(e -> e.getValue(),Collectors.summingInt(e -> 1)));

		return freqMap;
	}

	public boolean checkFlush(List<Card> hand) {
		String suit = hand.get(0).getSuit();
		int suitCount = 0;
		Map<CardValue, String> tempMap = new HashMap<CardValue, String>();

		for (Card c : hand) {
			tempMap.put(c.getValue(), c.getSuit());
		}
		for (String s : tempMap.values()) {
			if (s.equals(suit)) {
				suitCount++;
			}
		}
		return suitCount == 5;

	}

	public boolean checkPair(List<Card> hand) {

		Map<CardValue, Integer> freqMap = checkFrequency(hand);

		return freqMap.containsValue(2);

	}

	public boolean checkTwoPair(List<Card> hand) {
		Map<CardValue, Integer> freqMap = checkFrequency(hand);

		return Collections.frequency(freqMap.values(), 2) == 2;

	}

	public boolean checkThreeOfAKind(List<Card> hand) {

		Map<CardValue, Integer> freqMap = checkFrequency(hand);

		return freqMap.containsValue(3);
	}

	public boolean checkFourOfAKind(List<Card> hand) {
		Map<CardValue, Integer> freqMap = checkFrequency(hand);

		return freqMap.containsValue(4);

	}

	public boolean checkFullHouse(List<Card> hand) {
		Map<CardValue, Integer> freqMap = checkFrequency(hand);

		Set<Integer> fullHouseCheck = new HashSet<Integer>(freqMap.values());
		System.out.println(freqMap.keySet());
		return fullHouseCheck.contains(2) && fullHouseCheck.contains(3);

	}

	public boolean checkStraight(List<Card> hand) {

		List<CardValue> straightList = new ArrayList<CardValue>();

		for (Card c : hand) {
			straightList.add(c.getValue());
		}
		if (straightList.containsAll(wheelList)) {
			return true;
		}
		Collections.sort(straightList);

		int count = 0;
		int previousValue = straightList.remove(0).getValue();
		while (!straightList.isEmpty()) {

			int currentValue = straightList.remove(0).getValue();
			if (currentValue != previousValue + 1) {
				return false;
			}

			count++;
			previousValue = currentValue;
		}
		return count == 4;

	}

	public boolean checkStraightFlush(List<Card> hand) {

		return checkFlush(hand) == true && checkStraight(hand) == true;

	}

	public boolean checkRoyalFlush(List<Card> hand) {
		List<CardValue> valueList = new ArrayList<CardValue>();

		if (checkFlush(hand) == true) {
			for (Card c : hand) {
				valueList.add(c.getValue());
			}
			return valueList.containsAll(broadwayList);
		}
		return false;
	}

	public HandRankings evaluateHand(List<Card> hand) {

		if (checkRoyalFlush(hand)) {
			return HandRankings.royalFlush;

		} else if (checkStraightFlush(hand)) {
			return HandRankings.straightFlush;

		} else if (checkFourOfAKind(hand)) {
			return HandRankings.fourOfAKind;

		} else if (checkFullHouse(hand)) {
			return HandRankings.fullHouse;

		} else if (checkFlush(hand)) {
			return HandRankings.Flush;

		} else if (checkStraight(hand)) {
			return HandRankings.Straight;

		} else if (checkThreeOfAKind(hand)) {
			return HandRankings.threeOfAKind;

		} else if (checkTwoPair(hand)) {
			return HandRankings.twoPairs;

		} else if (checkPair(hand)) {
			return HandRankings.onePair;
		} else {
			return HandRankings.highCard;
		}

	}

}
