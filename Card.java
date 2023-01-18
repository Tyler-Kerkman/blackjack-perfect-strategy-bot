package sim;

public class Card {

	private Cards card;
	private Suits suit;
	private String symbol;
	
	public Card(Suits suit, Cards card) {
		this.card = card;
		this.suit = suit;
		
		this.symbol = getSymbol(this.card);
	}
	
	public int valueOf() {
		int sum = 0;
		switch (this.card) {
		case king:
		case queen:
		case jack:
		case ten:
			sum = 10;
			break;
		case nine:
			sum = 9;
			break;
		case eight:
			sum = 8;
			break;
		case seven:
			sum = 7;
			break;
		case six:
			sum = 6;
			break;
		case five:
			sum = 5;
			break;
		case four:
			sum = 4;
			break;
		case three:
			sum = 3;
			break;
		case two:
			sum = 2;
			break;
		case ace:
			sum = 11;
			break;
		}
		return sum;
	}
	
	private String getSymbol(Cards c) {
		String symbol = null;
		switch(c) {
		case king:
			symbol = "K";
			break;
		case queen:
			symbol = "Q";
			break;
		case jack:
			symbol = "J";
			break;
		case ten:
			symbol = "T";
			break;
		case nine:
			symbol = "9";
			break;
		case eight:
			symbol = "8";
			break;
		case seven:
			symbol = "7";
			break;
		case six:
			symbol = "6";
			break;
		case five:
			symbol = "5";
			break;
		case four:
			symbol = "4";
			break;
		case three:
			symbol = "3";
			break;
		case two:
			symbol = "2";
			break;
		case ace:
			symbol = "A";
			break;
		}
		return symbol;
	}
	
	public Cards getCard() {
		return this.card;
	}
	
	public Suits getSuit() {
		return this.suit;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	@Override
	public String toString() {
		return card.name() + " of " + suit.name().toLowerCase() + "s";
	}
	
}
