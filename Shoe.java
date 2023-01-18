package sim;

import java.util.ArrayList;

public class Shoe {

	private int numDecks;
	private ArrayList<Card> playingShoe = new ArrayList<Card>();
	private ArrayList<Deck> totalShoe = new ArrayList<Deck>();
	private int currentIndex;

	public Shoe(int numDecks) {
		// TODO Auto-generated constructor stub
		this.numDecks = numDecks;
		this.totalShoe = this.makeTotalShoe();
		this.playingShoe = this.shuffle();
		this.currentIndex = 0;
	}

	public ArrayList<Card> getShoe() {
		return playingShoe;
	}

	private ArrayList<Deck> makeTotalShoe() {
		ArrayList<Deck> totalShoe = new ArrayList<Deck>();
		for (int i = 0; i < numDecks; i++) {
			totalShoe.add(new Deck());
		}
		return totalShoe;
	}

	private ArrayList<Card> shuffle() {
		ArrayList<Card> getShuffledShoe = new ArrayList<Card>();
		for (int i = 0; i < totalShoe.size(); i++) {

			Card c;

			do {
				c = totalShoe.get(i).getRandomCard();
			} while (getShuffledShoe.contains(c));
			getShuffledShoe.add(c);
		}
		return getShuffledShoe;
	}

	public Card getRandomCard() {
		if (currentIndex > playingShoe.size()/2) {
			playingShoe = this.shuffle();
			currentIndex = 0;
		}

		return playingShoe.get(currentIndex++);
	}

	public void deal(Hand hand) {
		hand.addToHand(this.getRandomCard());
		hand.addToHand(this.getRandomCard());
	} 
	
}
