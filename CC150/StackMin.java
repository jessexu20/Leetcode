import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class StackMin{
	private Stack<Integer> intStack = new Stack();
	private Stack<Integer> minStack = new Stack();
	int min=Integer.MAX_VALUE;
	public void push(int x){
		intStack.push(x);
		if(x<=min){
			min=x;
			minStack.push(x);
		}
	}
	public int pop(){
		int res=0;
		if(!intStack.isEmpty())
			res=intStack.pop();
		if(res==minStack.peek())
			minStack.pop();
		return res;
	}
	public int getMin(){//3.2
		System.out.println(minStack);
		if(!minStack.isEmpty())
			return minStack.peek();
		else return 0;
	}
	public static void main(String args[]){
		StackMin sq=new StackMin();
		sq.push(4);sq.push(1);sq.push(2);sq.push(1);
		System.out.println(sq.getMin());
		sq.pop();
		System.out.println(sq.getMin());
		sq.pop();
		System.out.println(sq.getMin());
		sq.pop();
		System.out.println(sq.getMin());

	}
}