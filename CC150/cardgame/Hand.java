package cardgame;

import java.util.ArrayList;
import java.util.List;

public class Hand<T extends Card> {
	protected List<T> cards=new ArrayList<>();

	public void addCard(T card) {
		cards.add(card);
	}
	public void addHand(T [] hand) {
		for(T card:hand)
			cards.add(card);
	}
	public void traverse() {
		for (T card : cards) {
			System.out.print(card.suit());
			System.out.print(card.faceValue);
			System.out.print('\t');
		}
	}
}
