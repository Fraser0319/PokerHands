
public class Card {

	private String card;
	
	private String suit;
	
	private cardValue value;
	
	public String getSuit() {
		return suit;
	}

	public cardValue getValue() {
		return value;
	}

	public Card(String card) {
		this.card = card;
		this.value = convertValue(this.card.substring(0, 1));
		this.suit = this.card.substring(1, 2);
	}
	
	public cardValue convertValue(String v){
		
		switch(v){
		case "2":
			return cardValue.Two;
		case "3":
			return cardValue.Three;
		case "4":
			return cardValue.Four;
		case "5":
			return cardValue.Five;
		case "6":
			return cardValue.Six;
		case "7":
			return cardValue.Seven;
		case "8":
			return cardValue.Eight;
		case "9":
			return cardValue.Nine;
		case "T":
			return cardValue.T;
		case "J":
			return cardValue.J;
		case "Q":
			return cardValue.Q;
		case "K":
			return cardValue.K;
		case "A":
			return cardValue.A;
		default:
			return cardValue.fail;
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
