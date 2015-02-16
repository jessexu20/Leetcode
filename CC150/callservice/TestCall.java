package callservice;

public class TestCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallHandler callHandler=CallHandler.getInstance();

		Caller caller=new Caller("-1");
		callHandler.dispatchCall(caller);

		Caller caller1=new Caller("1");
		callHandler.dispatchCall(caller1);		
		Caller caller2=new Caller("2");
		callHandler.dispatchCall(caller2);
		Caller caller3=new Caller("3");
		callHandler.dispatchCall(caller3);
		caller.disconnect();
		Caller caller4=new Caller("4");
		callHandler.dispatchCall(caller4);
		Caller caller5=new Caller("5");
		callHandler.dispatchCall(caller5);
		caller2.disconnect();
		Caller caller6=new Caller("6");
		callHandler.dispatchCall(caller6);
		System.out.println(callHandler.callQueues.get(0).get(0).getCaller().name);
		
	}

}
