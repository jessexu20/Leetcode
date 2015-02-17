package cardgame;

public class BlackJackGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackJackGame bjg=new BlackJackGame();
		Deck<BlackJackCard> deck=new Deck<BlackJackCard>();
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < 13; j++) {
				deck.addCard(new BlackJackCard(j, Suit.getSuitfromValue(i)));
			}
		}
		deck.shuffle();
		BlackJackHand[] players=new BlackJackHand[3];
		for (int i = 0; i < players.length; i++) {
			players[i]=new BlackJackHand();
			BlackJackCard card =(BlackJackCard)deck.dealCard();
			players[i].addCard(card);
			BlackJackCard card2 =(BlackJackCard)deck.dealCard();
			players[i].addCard(card2);
		}
		for (int i = 0; i < players.length; i++) {
			System.out.print(i+": ");
			players[i].traverse();
			System.out.println(players[i].score());
		}
	}

}
