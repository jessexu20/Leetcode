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
		if (rank == Rank.RESPONDENT) {
			rank = Rank.MANAGER;
			System.out.println("handover to manager");
			handler.escalateAndReassign();
		}
		else if (rank == Rank.MANAGER) {
			rank = Rank.DIRECTOR;
			System.out.println("handover to director");
			handler.escalateAndReassign();
		}
		return rank;
	} 
	public void disconnect(){
		System.out.println(caller.name+" thank you for calling! Call ended");
		handler.callCompleted();
	}

}
