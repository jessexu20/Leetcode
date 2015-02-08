package cardgame;

import java.util.ArrayList;

public class Deck <T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex=0;
	public Deck(){
		ArrayList<T>newCards= new ArrayList<>();
		for (int i = 0; i <4; i++) {
			Suit s= Suit.getSuitfromValue(i);
			for (int j = 0; j < 13; j++) {
				Card card=new Card(j, s);
				newCards.add((T) card);
			}
		}
		cards=newCards;
		
	}
	public Deck(ArrayList<T>deckofCards){
		setDeckofCards(deckofCards);
	}
	public void setDeckofCards(ArrayList<T>deckofCards){
		cards=deckofCards;
	}
	public void shuffle(){
		for (int i = 0; i < cards.size(); i++) {
			int j =(int) (Math.random()*(cards.size()-1));
			Card tempCard=cards.get(i);
			cards.set(i,cards.get(j));
			cards.set(j, (T) tempCard);
		}
	}
	public int remainingCards(){
		return cards.size()-dealtIndex;
	}
	public T[] dealHand(int number){
		if (remainingCards()<number) {
			return null;
		}
		T [] handofCards= (T[]) new Card[number];
		for (int i = 0; i < number; i++) {
			handofCards[i]=dealCard();
		}
		return handofCards;
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
		for (Card card : cards) {
			System.out.print(card.suit());
			System.out.println(card.faceValue);
		}
	}
	
}
