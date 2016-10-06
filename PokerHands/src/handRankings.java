public enum HandRankings {

	highCard(1), // Highest value card.
	onePair(2), // Two cards of the same value.
	twoPairs(3), // Two different pairs.
	threeOfAKind(4), // Three cards of the same value.
	Straight(5), // All cards are consecutive values.
	Flush(6), // All cards of the same suit.
	fullHouse(7), // Three of a kind and a pair.
	fourOfAKind(8), // Four cards of the same value.
	straightFlush(9), // All cards are consecutive values of same suit.
	royalFlush(10); // Ten, Jack, Queen, King, Ace, in same suit.

	int value;

	HandRankings(int v) {
		value = v;
	}

}
