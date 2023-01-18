package sim;

import java.util.ArrayList;

public class Game {

	private Hand playerHand;
	private Hand computerHand;
//	private Deck deck;
	private Shoe shoe;
	private ArrayList<Hand> handsPlaying = new ArrayList<Hand>();
	private int money = 0;

//	public Game(Hand playerHand, Hand computerHand, Deck deck) {
	public Game(Hand playerHand, Hand computerHand, Shoe shoe) {
		// TODO Auto-generated constructor stub
		this.playerHand = playerHand;
		this.computerHand = computerHand;
//		this.deck = deck;
		this.shoe = shoe;
		handsPlaying.add(this.playerHand);

		this.playUserHand();

		this.playComputerHand();
		this.findWinner();
	}

	public int getMoney() {
		return money;
	}

	public String winner() {

		if (money / handsPlaying.size() > 100) {
			return "user";
		} else if (money / handsPlaying.size() < 100) {
			return "computer";
		} else {
			return "push";
		}

	}

	private void findWinner() {

		for (int i = 0; i < handsPlaying.size(); i++) {
			int compare = handsPlaying.get(i).compareTo(computerHand);

			if (compare == 0) {
				money += 100;
			} else if (compare > 0) {
				money += 200;
			}

		}

	}

	private void playComputerHand() {
		while (!this.playerHand.isBusted() && this.computerHand.sumHand() < 17 && !this.computerHand.isBusted()) {
//			this.computerHand.addToHand(this.deck.getRandomCard());
			this.computerHand.addToHand(this.shoe.getRandomCard());

		}

	}

	private void playUserHand() {

		for (int i = 0; i < handsPlaying.size(); i++) {

			while (!handsPlaying.get(i).isBusted() && !handsPlaying.get(i).isStanding()) {
				if (handsPlaying.get(i).isSplit()) {

					// 2,2
					if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.two)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.two)
							&& computerHand.getHand().get(0).valueOf() < 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.two)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.two)
							&& computerHand.getHand().get(0).valueOf() >= 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 3,3
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.three)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.three)
							&& computerHand.getHand().get(0).valueOf() < 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.three)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.three)
							&& computerHand.getHand().get(0).valueOf() >= 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 4,4
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.four)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.four)
							&& computerHand.getHand().get(0).valueOf() < 7
							&& computerHand.getHand().get(0).valueOf() > 4
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.four)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.four)
							&& (computerHand.getHand().get(0).valueOf() >= 7
									|| computerHand.getHand().get(0).valueOf() <= 4)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 5,5
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.five)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.five)
							&& computerHand.getHand().get(0).valueOf() < 10
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.five)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.five)
							&& computerHand.getHand().get(0).valueOf() >= 10
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 6,6
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.six)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.six)
							&& computerHand.getHand().get(0).valueOf() < 7
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.six)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.six)
							&& computerHand.getHand().get(0).valueOf() >= 7
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 7,7
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& computerHand.getHand().get(0).valueOf() < 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& computerHand.getHand().get(0).valueOf() >= 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 8,8
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.eight)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.eight)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 9,9
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.nine)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.nine)
							&& (computerHand.getHand().get(0).valueOf() >= 10
									|| computerHand.getHand().get(0).valueOf() == 7)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.nine)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.nine)
							&& computerHand.getHand().get(0).valueOf() < 10
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 10,10
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ten)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ten)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// A,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,2
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.two)
							&& (computerHand.getHand().get(0).valueOf() >= 5
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.two)
							&& (computerHand.getHand().get(0).valueOf() < 5
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 2,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.two)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 5
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.two)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 5
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,3
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.three)
							&& (computerHand.getHand().get(0).valueOf() >= 5
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.three)
							&& (computerHand.getHand().get(0).valueOf() < 5
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 3,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.three)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 5
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.three)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 5
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,4
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.four)
							&& (computerHand.getHand().get(0).valueOf() >= 4
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.four)
							&& (computerHand.getHand().get(0).valueOf() < 4
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 4,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.four)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 4
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.four)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 4
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,5
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.five)
							&& (computerHand.getHand().get(0).valueOf() >= 4
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.five)
							&& (computerHand.getHand().get(0).valueOf() < 4
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 5,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.five)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 4
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.five)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 4
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,6
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.six)
							&& (computerHand.getHand().get(0).valueOf() >= 3
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.six)
							&& (computerHand.getHand().get(0).valueOf() < 3
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 6,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.six)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 3
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.six)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 3
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,7
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& (computerHand.getHand().get(0).valueOf() >= 3
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& computerHand.getHand().get(0).valueOf() > 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& (computerHand.getHand().get(0).valueOf() < 3
									&& (computerHand.getHand().get(0).valueOf() > 6
											&& computerHand.getHand().get(0).valueOf() < 9))
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 7,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 3
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& computerHand.getHand().get(0).valueOf() > 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 3
									|| (computerHand.getHand().get(0).valueOf() > 6
											&& computerHand.getHand().get(0).valueOf() < 9))
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// A, 8
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.eight)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 8,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.eight)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// A, 9
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.nine)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 9,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.nine)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// A, 10
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ten)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 10,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ten)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 5-8
					else if (handsPlaying.get(i).sumHand() == 5) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 6) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 7) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 8) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 9
					else if (handsPlaying.get(i).sumHand() == 9 && (computerHand.getHand().get(0).valueOf() >= 3
							&& computerHand.getHand().get(0).valueOf() <= 6)) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 9 && (computerHand.getHand().get(0).valueOf() > 6
							|| computerHand.getHand().get(0).valueOf() == 2)) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 10
					else if (handsPlaying.get(i).sumHand() == 10 && computerHand.getHand().get(0).valueOf() <= 9) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 10 && computerHand.getHand().get(0).valueOf() > 9) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 11
					else if (handsPlaying.get(i).sumHand() == 11 && computerHand.getHand().get(0).valueOf() <= 10) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 11 && computerHand.getHand().get(0).valueOf() > 10) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 12
					else if (handsPlaying.get(i).sumHand() == 12 && (computerHand.getHand().get(0).valueOf() >= 4
							&& computerHand.getHand().get(0).valueOf() <= 6)) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 12 && computerHand.getHand().get(0).valueOf() >= 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 13
					else if (handsPlaying.get(i).sumHand() == 13 && computerHand.getHand().get(0).valueOf() <= 6) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 13 && computerHand.getHand().get(0).valueOf() > 6) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 14
					else if (handsPlaying.get(i).sumHand() == 14 && computerHand.getHand().get(0).valueOf() <= 6) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 14 && computerHand.getHand().get(0).valueOf() > 6) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 15
					else if (handsPlaying.get(i).sumHand() == 15 && computerHand.getHand().get(0).valueOf() <= 6) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 15 && computerHand.getHand().get(0).valueOf() > 6) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 16
					else if (handsPlaying.get(i).sumHand() == 16 && computerHand.getHand().get(0).valueOf() <= 6) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 16 && computerHand.getHand().get(0).valueOf() > 6) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 17
					else if (handsPlaying.get(i).sumHand() >= 17) {
						//System.out.println("SEVENTEEN");
						makeMove("standing", handsPlaying.get(i));
					}

				} else {
					// 2,2
					if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.two)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.two)
							&& computerHand.getHand().get(0).valueOf() < 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("splitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.two)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.two)
							&& computerHand.getHand().get(0).valueOf() >= 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 3,3
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.three)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.three)
							&& computerHand.getHand().get(0).valueOf() < 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("splitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.three)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.three)
							&& computerHand.getHand().get(0).valueOf() >= 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 4,4
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.four)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.four)
							&& computerHand.getHand().get(0).valueOf() < 7
							&& computerHand.getHand().get(0).valueOf() > 4
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("splitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.four)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.four)
							&& (computerHand.getHand().get(0).valueOf() >= 7
									|| computerHand.getHand().get(0).valueOf() <= 4)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 5,5
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.five)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.five)
							&& computerHand.getHand().get(0).valueOf() < 10
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.five)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.five)
							&& computerHand.getHand().get(0).valueOf() >= 10
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 6,6
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.six)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.six)
							&& computerHand.getHand().get(0).valueOf() < 7
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("splitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.six)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.six)
							&& computerHand.getHand().get(0).valueOf() >= 7
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 7,7
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& computerHand.getHand().get(0).valueOf() < 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("splitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& computerHand.getHand().get(0).valueOf() >= 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 8,8
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.eight)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.eight)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("splitting", handsPlaying.get(i));
					}
					// 9,9
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.nine)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.nine)
							&& (computerHand.getHand().get(0).valueOf() >= 10
									|| computerHand.getHand().get(0).valueOf() == 7)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.nine)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.nine)
							&& computerHand.getHand().get(0).valueOf() < 10
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("splitting", handsPlaying.get(i));
					}
					// 10,10
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ten)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ten)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// A,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("splitting", handsPlaying.get(i));
					}
					// A,2
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.two)
							&& (computerHand.getHand().get(0).valueOf() >= 5
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.two)
							&& (computerHand.getHand().get(0).valueOf() < 5
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 2,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.two)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 5
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.two)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 5
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,3
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.three)
							&& (computerHand.getHand().get(0).valueOf() >= 5
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.three)
							&& (computerHand.getHand().get(0).valueOf() < 5
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 3,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.three)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 5
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.three)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 5
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,4
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.four)
							&& (computerHand.getHand().get(0).valueOf() >= 4
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.four)
							&& (computerHand.getHand().get(0).valueOf() < 4
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 4,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.four)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 4
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.four)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 4
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,5
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.five)
							&& (computerHand.getHand().get(0).valueOf() >= 4
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.five)
							&& (computerHand.getHand().get(0).valueOf() < 4
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 5,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.five)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 4
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.five)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 4
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,6
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.six)
							&& (computerHand.getHand().get(0).valueOf() >= 3
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.six)
							&& (computerHand.getHand().get(0).valueOf() < 3
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 6,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.six)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 3
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.six)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 3
									|| computerHand.getHand().get(0).valueOf() > 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// A,7
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& (computerHand.getHand().get(0).valueOf() >= 3
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& computerHand.getHand().get(0).valueOf() > 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.seven)
							&& (computerHand.getHand().get(0).valueOf() < 3
									&& (computerHand.getHand().get(0).valueOf() > 6
											&& computerHand.getHand().get(0).valueOf() < 9))
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 7,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() >= 3
									&& computerHand.getHand().get(0).valueOf() <= 6)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& computerHand.getHand().get(0).valueOf() > 8
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.seven)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& (computerHand.getHand().get(0).valueOf() < 3
									|| (computerHand.getHand().get(0).valueOf() > 6
											&& computerHand.getHand().get(0).valueOf() < 9))
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// A, 8
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.eight)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 8,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.eight)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// A, 9
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.nine)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 9,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.nine)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// A, 10
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ten)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 10,A
					else if (handsPlaying.get(i).getHand().get(0).getCard().equals(Cards.ten)
							&& handsPlaying.get(i).getHand().get(1).getCard().equals(Cards.ace)
							&& handsPlaying.get(i).getHand().size() == 2) {
						makeMove("standing", handsPlaying.get(i));
					}
					// 5-8
					else if (handsPlaying.get(i).sumHand() == 5) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 6) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 7) {
						makeMove("hitting", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 8) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 9
					else if (handsPlaying.get(i).sumHand() == 9 && (computerHand.getHand().get(0).valueOf() >= 3
							&& computerHand.getHand().get(0).valueOf() <= 6)) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 9 && (computerHand.getHand().get(0).valueOf() > 6
							|| computerHand.getHand().get(0).valueOf() == 2)) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 10
					else if (handsPlaying.get(i).sumHand() == 10 && computerHand.getHand().get(0).valueOf() <= 9) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 10 && computerHand.getHand().get(0).valueOf() > 9) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 11
					else if (handsPlaying.get(i).sumHand() == 11 && computerHand.getHand().get(0).valueOf() <= 10) {
						makeMove("double down", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 11 && computerHand.getHand().get(0).valueOf() > 10) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 12
					else if (handsPlaying.get(i).sumHand() == 12 && (computerHand.getHand().get(0).valueOf() >= 4
							&& computerHand.getHand().get(0).valueOf() <= 6)) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 12 && computerHand.getHand().get(0).valueOf() >= 2) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 13
					else if (handsPlaying.get(i).sumHand() == 13 && computerHand.getHand().get(0).valueOf() <= 6) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 13 && computerHand.getHand().get(0).valueOf() > 6) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 14
					else if (handsPlaying.get(i).sumHand() == 14 && computerHand.getHand().get(0).valueOf() <= 6) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 14 && computerHand.getHand().get(0).valueOf() > 6) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 15
					else if (handsPlaying.get(i).sumHand() == 15 && computerHand.getHand().get(0).valueOf() <= 6) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 15 && computerHand.getHand().get(0).valueOf() > 6) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 16
					else if (handsPlaying.get(i).sumHand() == 16 && computerHand.getHand().get(0).valueOf() <= 6) {
						makeMove("standing", handsPlaying.get(i));
					} else if (handsPlaying.get(i).sumHand() == 16 && computerHand.getHand().get(0).valueOf() > 6) {
						makeMove("hitting", handsPlaying.get(i));
					}
					// 17
					else if (handsPlaying.get(i).sumHand() >= 17) {

						makeMove("standing", handsPlaying.get(i));
					}
				}

			}
		}
	}

	private void makeMove(String input, Hand hand) {
		// if splitting
		String move = input;
		if (move.equals("splitting")) {
			money -= 100;
			Hand split1 = new Hand();
			split1.addToHand(hand.getHand().get(0));
//			split1.addToHand(deck.getRandomCard());
			split1.addToHand(shoe.getRandomCard());
			split1.split();
			Hand split2 = new Hand();
			split2.addToHand(hand.getHand().get(1));
//			split2.addToHand(deck.getRandomCard());
			split2.addToHand(shoe.getRandomCard());
			split2.split();
			handsPlaying.set(0, split1);
			handsPlaying.add(split2);
		} else if (move.equals("standing")) {
			hand.stand();
		} else if (move.equals("hitting")) {
//			hand.addToHand(deck.getRandomCard());
			hand.addToHand(shoe.getRandomCard());
		} else if (move.equals("double down")) {
			money -= 100;
//			hand.addToHand(deck.getRandomCard());
			hand.addToHand(shoe.getRandomCard());
			hand.stand();
		}
	}

}
