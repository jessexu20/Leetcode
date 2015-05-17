package callservice;

public enum Rank {
	RESPONDENT(0),MANAGER(1),DIRECTOR(2);
	private int rank;
	Rank(int r) {
		rank=r;
		// TODO Auto-generated constructor stub
	}
	public int getValue() {
		// TODO Auto-generated method stub
		return rank;
	}
	public static Rank getRankfromValue(int value){
		switch (value) {
		case 0:
			return RESPONDENT;
		case 1:
			return MANAGER;
		case 2:
			return DIRECTOR;
		default:
			return RESPONDENT;
		}
	}
}
