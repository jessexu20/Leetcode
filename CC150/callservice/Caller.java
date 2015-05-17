package callservice;

public class Caller {
	String name;
	Call call;
	public Caller(String n){
		name=n;
		call=null;
	}
	private Call getCall() {
		return call;
	}
	public void setCall(Call call) {
		this.call = call;
	}
	public void disconnect() {
		this.call.disconnect();
	}
	public void furtherRequest(){
		this.call.incrementRank();
	}
	
}
