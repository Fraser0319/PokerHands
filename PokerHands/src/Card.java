
public class Card {

	private String card;
	
	private String suit;
	
	private String value;
	
	public String getSuit() {
		return suit;
	}

	public String getValue() {
		return value;
	}

	public Card(String card) {
		this.card = card;
		this.value = this.card.substring(0, 1);
		this.suit = this.card.substring(1, 2);
	}

	

	public String getCard() {
		return card;
	}

	@Override
	public String toString() {
		return this.card;
	}

}
