package sim;

import java.util.ArrayList;

public class Deck {

	private Card[] deck = new Card[52];
	private ArrayList<Card> usedCards = new ArrayList<Card>();
	
	public Deck() {
		// TODO Auto-generated constructor stub
		initializeDeck();
	}
	
	public void addToUsedCards(Card card) {
		usedCards.add(card);
	}
	
	public Card getRandomCard() {
		Card c;
		do {
			c  = deck[getRandomInt()];
		}while(usedCards.contains(c));
		usedCards.add(c);
		return c;
	}

	private int getRandomInt() {
		return (int) (Math.random() * 52);
	}
	
	public Card[] getDeck() {
		return deck;
	}
	
	private void initializeDeck() {
		for (int i = 0; i < Cards.values().length; i++) {
			for (int j = 0; j < Suits.values().length; j++) {

				Card c = new Card(Suits.values()[j], Cards.values()[i]);
				deck[(i * 4) + j] = c;

			}
		}
	}
	
	public void deal(Hand hand) {
		hand.addToHand(this.getRandomCard());
		hand.addToHand(this.getRandomCard());
	}
	
}
