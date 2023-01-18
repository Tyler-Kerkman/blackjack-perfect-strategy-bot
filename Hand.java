package sim;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand = new ArrayList<Card>();
	private boolean bust = false;
	private boolean stand = false;
	private boolean split = false;
	public int money;

	public Hand() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void addToHand(Card c) {
		hand.add(c);
	}

	public boolean isBusted() {
		return this.bust;
	}

	public void bust() {
		bust = true;
	}

	public boolean isStanding() {
		return this.stand;
	}

	public void stand() {
		stand = true;
	}
	
	public boolean isSplit() {
		return this.split;
	}

	public void split() {
		split = true;
	}
	
	public int sumHand() {
		int sum = 0;
		int numAces = 0;
		for (int i = 0; i < hand.size(); i++) {

			if (hand.get(i).getCard() != Cards.ace) {

				switch (hand.get(i).getCard()) {

				case king:
				case queen:
				case jack:
				case ten:
					sum += 10;
					break;
				case nine:
					sum += 9;
					break;
				case eight:
					sum += 8;
					break;
				case seven:
					sum += 7;
					break;
				case six:
					sum += 6;
					break;
				case five:
					sum += 5;
					break;
				case four:
					sum += 4;
					break;
				case three:
					sum += 3;
					break;
				case two:
					sum += 2;
					break;
				default:
					break;
				}

			} else {

				numAces++;

			}

		}

		for (int i = 0; i < numAces; i++) {

			if (sum + 11 > 21) {
				sum += 1;
			} else {
				sum += 11;
			}

		}

		if (sum > 21) {
			this.bust();
			return 0;
		}
		return sum;
	}

	public int compareTo(Hand h) {
		
		
		if (this.bust) {
			return -1;
		} else if (h.bust) {
			return 1;
		} else {
			return this.sumHand() - h.sumHand();
		}
	}
	
	@Override
	public String toString() {
		String toReturn = "[";
		for(int i = 0; i < this.getHand().size(); i++) {
			if(i == 0) {
				toReturn += this.getHand().get(i);
			}else {
				toReturn += ", " + this.getHand().get(i);
			}
		}
		toReturn += "]";
		return toReturn;
	}

}
