package callservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public class CallHandler{
	private static CallHandler instance;
	private final int LEVELS=3;
	private final int NUM_RESPONDENTS=3;
	private final int NUM_MANAGERS = 2;
	private final int NUM_DIRECTORS = 1;

	List<List<Employee>> employeeLevels=new ArrayList<>();
	List<List<Call>> callQueues=new ArrayList<>();
	protected CallHandler(){
		List<Employee> respondents=new ArrayList<>();
		for (int i = 0; i < NUM_RESPONDENTS; i++) {
			respondents.add(new Respondent());
		}
		List<Employee> managers=new ArrayList<>();
		for (int i = 0; i < NUM_MANAGERS; i++) {
			managers.add(new Manager());
		}
		List<Employee> directors=new ArrayList<>();
		for (int i = 0; i < NUM_DIRECTORS; i++) {
			directors.add(new Director());
		}
		employeeLevels.add(respondents);
		employeeLevels.add(managers);
		employeeLevels.add(directors);
		callQueues.add(new ArrayList<Call>());
		callQueues.add(new ArrayList<Call>());
		callQueues.add(new ArrayList<Call>());
	}
	public static CallHandler getInstance(){
		if (instance==null) {
			instance=new CallHandler();
		}
		return instance;
	}
	public Employee getHandlerforCall(Call call){
		for (int i = 0; i < NUM_RESPONDENTS; i++) {
			if (employeeLevels.get(0).get(i).isFree()) {
				return employeeLevels.get(0).get(i);
			}
		}
		return null;
	}
	public void dispatchCall(Caller caller){
		Call call=new Call(caller);
		caller.setCall(call);
		call.setCaller(caller);
		dispatchCall(call);
		
	}
	public void dispatchCall(Call call){
		Employee employee=getHandlerforCall(call);
		if (employee!=null) {
			employee.receiveCall(call);
			System.out.println("received call by"+employee);
			call.setHandler(employee);
		}
		else {
			System.out.println("please wait: "+call.getCaller().name);
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}
	public boolean assignCall(Employee employee){
		if (employee.assignNewCall()) {
			Call oldCall=callQueues.get(employee.getRank().getValue()).get(0);
			employee.receiveCall(oldCall);
			return true;
		}
		else return false;
	}
}