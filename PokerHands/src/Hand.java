import java.awt.List;
import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public Hand(ArrayList<Card> hand){
		this.hand = hand;
	}
	
	public enum handRankings{

		highCard, //Highest value card.
		onePair, // Two cards of the same value.
		twoPairs, //Two different pairs.
		threeOfAKind, //Three cards of the same value.
		Straight, // All cards are consecutive values.
		Flush, //All cards of the same suit.
		fullHouse, // Three of a kind and a pair.
		fourOfAKind, // Four cards of the same value.
		straightFlush,// All cards are consecutive values of same suit.
		royalFlush, // Ten, Jack, Queen, King, Ace, in same suit.
		fail
		
	}
			
	public ArrayList<Card> createHand(String cards) {

		for (String part : cards.split("\\s+")) {
			Card currentCard = new Card(part);
			hand.add(currentCard);
		}
		hand.removeAll(hand);
		return hand;
	}
	public handRankings rankHand(ArrayList<Card> hand){
		String c = hand.get(0).getSuit();
		for(Card card : hand){
			if(card.getSuit() == c){
				continue;
			}else{
				return handRankings.fail;
			}

		}
		return handRankings.Flush;
		
	}

	@Override
	public String toString() {
		return hand.toString();
	}
	
	

}
