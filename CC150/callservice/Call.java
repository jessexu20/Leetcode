package callservice;

public class Call {
	private Rank rank;
	private Caller caller;
	private Employee handler;
	public Call(Caller c) {
		rank=Rank.RESPONDENT;
		caller=c;
		// TODO Auto-generated constructor stub
	}

	public Caller getCaller() {
		return caller;
	}

	public void setCaller(Caller caller) {
		this.caller = caller;
	}

	public Employee getHandler() {
		return handler;
	}

	public void setHandler(Employee e) {
		this.handler = e; 
		System.out.println("call set by"+e);
	}
	public Rank getRank() { return rank; }
	public void setRank(Rank r) { rank = r; } 
	public Rank incrementRank() {
		if (rank!=Rank.DIRECTOR) {
			return Rank.getRankfromValue(rank.getValue()+1);
		}
		else return rank;
	} 
	public void disconnect(){
		handler.callCompleted();
		handler=null;
		caller=null;
		rank=Rank.RESPONDENT;
	}

}
