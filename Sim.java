package sim;

public class Sim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sim(100);

	}

	public static void sim(int numSims) {

		int money = 1000;
		int humanWins = 0;
		int computerWins = 0;

		for (int i = 0; i < numSims; i++) {
			// cost to play
			money -= 100;

			// initialize deck
//			Deck deck = new Deck();
			Shoe shoe = new Shoe(6);

			// user hand (potential for splitting)
			Hand playerHand = new Hand();

			// computer hand
			Hand computerHand = new Hand();

			// deal hands
//			deck.deal(playerHand);
//			deck.deal(computerHand);
			shoe.deal(playerHand);
			shoe.deal(computerHand);

			// Original Bet
//			Game game = new Game(playerHand, computerHand, deck);
			Game game = new Game(playerHand, computerHand, shoe);

			
			int mon = game.getMoney();
			String winner = game.winner();
			switch (winner) {
			case "user":
				humanWins++;
				break;
			case "computer":
				computerWins++;
				break;
			default:
				break;
			}
			money += mon;

		}

		System.out.printf(
				"You ended with $%d, and won %d times. The computer won %d times. You drew %d times. You had a win percentage of %.0f%%.",
				money, humanWins, computerWins, numSims - (humanWins + computerWins), humanWins / (double) numSims * 100);

	}

}
