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
		CallHandler.getInstance().dispatchCall(currentCall);
		currentCall=null;
		assignNewCall();
		
	}
	/* the issue is resolved, finish the call */ 
	public void callCompleted(){
		currentCall=null;
		assignNewCall();
	}
	public boolean assignNewCall(){
		if (!isFree()) {
			return false;
		}
		else {
			CallHandler.getInstance().assignCall(this);
			return true;
		}
	}
	public boolean isFree() {
		return currentCall == null;
	}
	public Rank getRank() {
		return rank; 
	}

}
