
public class Card {

	private String card;
	
	private String suit;
	
	private CardValue value;
	
	public String getSuit() {
		return suit;
	}

	public CardValue getValue() {
		return value;
	}

	public Card(String card) {
		this.card = card;
		this.value = convertValue(this.card.substring(0, 1));
		this.suit = this.card.substring(1, 2);
	}
	
	public CardValue convertValue(String v){
		
		switch(v){
		case "2":
			return CardValue.Two;
		case "3":
			return CardValue.Three;
		case "4":
			return CardValue.Four;
		case "5":
			return CardValue.Five;
		case "6":
			return CardValue.Six;
		case "7":
			return CardValue.Seven;
		case "8":
			return CardValue.Eight;
		case "9":
			return CardValue.Nine;
		case "T":
			return CardValue.T;
		case "J":
			return CardValue.J;
		case "Q":
			return CardValue.Q;
		case "K":
			return CardValue.K;
		case "A":
			return CardValue.A;
		default:
			return CardValue.fail;
		}
		
	}

	public String getCard() {
		return card;
	}

	@Override
	public String toString() {
		return this.card;
	}

}
