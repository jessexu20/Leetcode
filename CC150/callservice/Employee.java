package callservice;

public abstract class Employee {

	private Call currentCall = null; 
	protected Rank rank;
	public Employee() {
	};
	/* Start the conversation */
	public void receiveCall(Call call) {
		if (currentCall==null) {
			currentCall=call;
		}
	}
	
	public void escalateAndReassign() {
		if (this.getRank()==Rank.RESPONDENT) {
			currentCall.incrementRank();
			currentCall.setHandler(new Manager());
		}
		else if (this.getRank()==Rank.MANAGER) {
			currentCall.incrementRank();
			currentCall.setHandler(new Director());
		}
		
	}
	/* the issue is resolved, finish the call */ 
	public void callCompleted(){
		currentCall=null;
	}
	public boolean assignNewCall(){
		return isFree();
	}
	public boolean isFree() {
		return currentCall == null;
	}
	public Rank getRank() {
		return rank; 
	}

}
