package cardgame;
public  class Card {
	private boolean flag=true;
	public int faceValue;
	public Suit suit;
	public Card(int v, Suit s){
		faceValue=v;
		suit=s;
	}
//	public abstract int value();
	public Suit suit(){
		return suit;
	}
	public boolean isAvailable() {
		return flag;
	}
	public void setAvailable() {
		flag=true;
	}
	public void setUnavailable() {
		flag=false;
	}
}
