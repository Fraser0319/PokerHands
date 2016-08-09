
public class Player {
	
	

	private String name;
	private Hand playersHand;
	
	public Hand getPlayersHand() {
		return playersHand;
	}

	public String getName() {
		return name;
	}

	public Player(String name, Hand playersHand){
		this.name = name;
		this.playersHand = playersHand;
	}
		
	@Override
	public String toString() {
		return this.name + " " + this.playersHand;
	}
	
}
