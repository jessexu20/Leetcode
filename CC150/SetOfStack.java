import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class SetOfStack{//3.3
	int thrd=Integer.MAX_VALUE;
	int current=0;
	List<Stack<Integer>> list; 
	public SetOfStack(int t){
		thrd=t;
		list=new ArrayList();
		createStack();
		current=0;
	}
	private void createStack(){
		list.add(new Stack<Integer>());
		current++;
	}
	public void push(int x){
		if(list.get(current).size()<thrd)
			list.get(current).push(x);
		else{
			createStack();
			list.get(current).push(x);
		}
	}
	public int pop(){
		int result=0;
		if(!list.get(current).isEmpty()){
			result=list.get(current).pop();
		}
		else{
			list.remove(current);
			current--;
			while(list.get(current).isEmpty())
				current--;
			if(current<0)
				return -1;
			else result=list.get(current).pop();
		}
		return result;
	}
	public int popAt(int num){
		int result=0;
		if(num>current)
			return -1;
		if(!list.get(num).isEmpty()){
			result=list.get(num).pop();
		}
		else{
			return -1;
		}
		return result;
	}
	public void print(){
		System.out.println(list);
	}
	
	public static void main(String args[]){
		SetOfStack sos=new SetOfStack(2);
		sos.push(1);sos.push(2);sos.push(3);
		sos.push(4);sos.push(5);sos.push(6);
		sos.print();
		sos.popAt(1);
		sos.print();
		sos.pop();sos.pop();sos.pop();
		sos.print();
		
		
	}
}