package cardgame;

public class BlackJackCard extends Card{

	public BlackJackCard(int v, Suit s) {
		super(v, s);
		// TODO Auto-generated constructor stub
	}

	public int value() {
		// TODO Auto-generated method stub
		if (faceValue>=11 && faceValue<=13) {
			return 10;
		}
		else if (isAce()) {
			return 1;
		}
		else return faceValue;
	}
	public boolean isAce() {
		return faceValue==1;
	}
	
	public int maxValue(){
		if (isAce()) {
			return 11;
		}
		else return faceValue;
	}
	public int minValue(){
		if (isAce()) {
			return 1;
		}
		else return faceValue;
	}	
	
	
}
