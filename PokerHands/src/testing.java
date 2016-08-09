import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class testing {

	@Test
	public void testCreateCard() {
		Card c1 = new Card("8C");
		Card c2 = new Card("TS");
		Card c3 = new Card("KC");
		Card c4 = new Card("9H");
		Card c5 = new Card("4S");
		Card c6 = new Card("8C");
		Card c7 = new Card("TS");
		Card c8 = new Card("KC");
		Card c9 = new Card("9H");
		Card c10 = new Card("4S");

		ArrayList<Card> temp = new ArrayList<Card>();
		temp.add(c1);
		temp.add(c2);
		temp.add(c3);
		temp.add(c4);
		temp.add(c5);
		Hand h = new Hand(temp);
		// System.out.println(temp);
		// System.out.println(h.createHand("8C TS KC 9H 4S"));
		assertEquals(temp, h.createHand("8C TS KC 9H 4S"));

	}

	@Test
	public void testPlayerWithHand() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		ArrayList<Card> hand2 = new ArrayList<Card>();
		Hand h1 = new Hand(hand1);
		Hand h2 = new Hand(hand2);

		Card c1 = new Card("8C");
		Card c2 = new Card("TS");
		Card c3 = new Card("KC");
		Card c4 = new Card("9H");
		Card c5 = new Card("4S");
		Card c6 = new Card("7D");
		Card c7 = new Card("2S");
		Card c8 = new Card("5D");
		Card c9 = new Card("3S");
		Card c10 = new Card("AC");
		hand1.add(c1);
		hand1.add(c2);
		hand1.add(c3);
		hand1.add(c4);
		hand1.add(c5);
		hand2.add(c6);
		hand2.add(c7);
		hand2.add(c8);
		hand2.add(c9);
		hand2.add(c10);

		Player p1 = new Player("Player 1", h1);
		Player p2 = new Player("Player 2", h2);

		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(c1.getValue());
		System.out.println(c1.getSuit());

	}

	// @Test
	// public void testEvaluateHand(){
	//
	// ArrayList<Card> hand1 = new ArrayList<Card>();
	// ArrayList<Card> hand2 = new ArrayList<Card>();
	// Hand h1 = new Hand(hand1);
	// Hand h2 = new Hand(hand2);
	//
	// Card c1 = new Card("8C");
	// Card c2 = new Card("8S");
	// Card c3 = new Card("KC");
	// Card c4 = new Card("KH");
	// Card c5 = new Card("KD");
	// Card c6 = new Card("7C");
	// Card c7 = new Card("2C");
	// Card c8 = new Card("5C");
	// Card c9 = new Card("3C");
	// Card c10 = new Card("AC");
	// hand1.add(c1);
	// hand1.add(c2);
	// hand1.add(c3);
	// hand1.add(c4);
	// hand1.add(c5);
	// hand2.add(c6);
	// hand2.add(c7);
	// hand2.add(c8);
	// hand2.add(c9);
	// hand2.add(c10);
	//
	// Player p1 = new Player("Player 1", h1);
	// Player p2 = new Player("Player 2", h2);
	//
	//// h1.rankHand(hand1);
	//// h1.rankHand(hand2);
	//
	// assertTrue(handRankings.fullHouse== h1.checkPair(hand1));
	//
	// assertTrue(handRankings.Flush == h2.checkFlush(hand2));
	//
	// }

	@Test
	public void testHighCard() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		Hand h1 = new Hand(hand1);
		Card c1 = new Card("8C");
		Card c2 = new Card("2S");
		Card c3 = new Card("AD");
		Card c4 = new Card("3H");
		Card c5 = new Card("5D");
		hand1.add(c1);
		hand1.add(c2);
		hand1.add(c3);
		hand1.add(c4);
		hand1.add(c5);

		System.out.println("check pair test : " + h1.checkPair(hand1));
		assertTrue(handRankings.highCard == h1.checkPair(hand1));

	}

	@Test
	public void testOnePair() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		Hand h1 = new Hand(hand1);
		Card c1 = new Card("8C");
		Card c2 = new Card("2S");
		Card c3 = new Card("8D");
		Card c4 = new Card("3H");
		Card c5 = new Card("5D");
		hand1.add(c1);
		hand1.add(c2);
		hand1.add(c3);
		hand1.add(c4);
		hand1.add(c5);

		System.out.println("check pair test : " + h1.checkPair(hand1));
		assertTrue(handRankings.onePair == h1.checkPair(hand1));

	}

	@Test
	public void testTwoPair() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		Hand h1 = new Hand(hand1);
		Card c1 = new Card("8C");
		Card c2 = new Card("5S");
		Card c3 = new Card("8D");
		Card c4 = new Card("3H");
		Card c5 = new Card("5D");
		hand1.add(c1);
		hand1.add(c2);
		hand1.add(c3);
		hand1.add(c4);
		hand1.add(c5);

		assertTrue(handRankings.twoPairs == h1.checkPair(hand1));
	}

	@Test
	public void testThreeOfAKind() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		Hand h1 = new Hand(hand1);
		Card c1 = new Card("8C");
		Card c2 = new Card("2S");
		Card c3 = new Card("8D");
		Card c4 = new Card("3H");
		Card c5 = new Card("8D");
		hand1.add(c1);
		hand1.add(c2);
		hand1.add(c3);
		hand1.add(c4);
		hand1.add(c5);

		assertTrue(handRankings.threeOfAKind == h1.checkPair(hand1));
	}

	@Test
	public void testFourOfAKind() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		Hand h1 = new Hand(hand1);
		Card c1 = new Card("8C");
		Card c2 = new Card("8S");
		Card c3 = new Card("8D");
		Card c4 = new Card("3H");
		Card c5 = new Card("8D");
		hand1.add(c1);
		hand1.add(c2);
		hand1.add(c3);
		hand1.add(c4);
		hand1.add(c5);

		assertTrue(handRankings.fourOfAKind == h1.checkPair(hand1));
	}

	@Test
	public void testFlush() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		Hand h1 = new Hand(hand1);
		Card c1 = new Card("8D");
		Card c2 = new Card("2D");
		Card c3 = new Card("4D");
		Card c4 = new Card("3D");
		Card c5 = new Card("5D");
		hand1.add(c1);
		hand1.add(c2);
		hand1.add(c3);
		hand1.add(c4);
		hand1.add(c5);

		assertTrue(handRankings.Flush == h1.checkFlush(hand1));
	}

	@Test
	public void testfullHouse() {
		ArrayList<Card> hand1 = new ArrayList<Card>();
		Hand h1 = new Hand(hand1);
		Card c1 = new Card("8C");
		Card c2 = new Card("8S");
		Card c3 = new Card("8D");
		Card c4 = new Card("5H");
		Card c5 = new Card("5D");
		hand1.add(c1);
		hand1.add(c2);
		hand1.add(c3);
		hand1.add(c4);
		hand1.add(c5);

		assertTrue(handRankings.fullHouse == h1.checkPair(hand1));

	}

	@Test
	public void testStraight() {

	}

}
