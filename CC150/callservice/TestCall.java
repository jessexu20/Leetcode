package callservice;

public class TestCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallHandler callHandler=CallHandler.getInstance();

		Caller caller=new Caller("User0");
		callHandler.dispatchCall(caller);

		Caller caller1=new Caller("User1");
		callHandler.dispatchCall(caller1);		
		Caller caller2=new Caller("User2");
		callHandler.dispatchCall(caller2);
		Caller caller3=new Caller("User3");
		callHandler.dispatchCall(caller3);
//		caller.disconnect();
		caller1.furtherRequest();
		caller1.furtherRequest();
		Caller caller4=new Caller("User4");
		callHandler.dispatchCall(caller4);
		Caller caller5=new Caller("User5");
		callHandler.dispatchCall(caller5);
		caller2.disconnect();
		Caller caller6=new Caller("User6");
		callHandler.dispatchCall(caller6);
		System.out.println(callHandler.callQueues.get(0).get(0).getCaller().name);
		
	}

}
