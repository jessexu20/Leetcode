package cardgame;

public class BlackJackGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackJackGame bjg=new BlackJackGame();
		Deck<Card> deck=new Deck<>();
//		deck.traverse();
		deck.shuffle();
//		deck.traverse();
		BlackJackHand[] players=new BlackJackHand[3];
		for (int i = 0; i < players.length; i++) {
			players[i]=new BlackJackHand();
			BlackJackCard cards =(BlackJackCard) deck.dealCard();
			players[i].addCard(cards);
			players[i].traverse();
		}
		
		
	}

}
