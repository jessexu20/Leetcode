package cardgame;

import java.util.ArrayList;

public class Deck <T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex=0;
	public Deck(){
		ArrayList<T>newCards= new ArrayList<>();
		cards=newCards;
	}
	public Deck(ArrayList<T>deckofCards){
		setDeckofCards(deckofCards);
	}
	public void addCard(T card) {
		cards.add(card);
	}
	public void setDeckofCards(ArrayList<T>deckofCards){
		cards=deckofCards;
	}
	public void shuffle(){
		for (int i = 0; i < cards.size(); i++) {
			int j =(int) (Math.random()*(cards.size()-1));
			T tempCard=cards.get(i);
			cards.set(i,cards.get(j));
			cards.set(j, tempCard);
		}
	}
	public int remainingCards(){
		return cards.size()-dealtIndex;
	}

	public T dealCard(){
		if (remainingCards()<=0) {
			return null;
			
		}
		T card=cards.get(dealtIndex);
		card.setUnavailable();
		dealtIndex++;
		return card;
	}
	public void traverse() {
		for (T card : cards) {
			System.out.print(card.suit());
			System.out.println(card.faceValue);
		}
	}
	
}
