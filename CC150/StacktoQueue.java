import java.util.Stack;
public class StacktoQueue{//3.5
	private Stack<Integer>stack1;
	private Stack<Integer>stack2;
	public StacktoQueue(){
		stack1=new Stack();
		stack2=new Stack();
	}
	public void enqueue(int x){
		stack1.push(x);
	}
	private void dump(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				int x=stack1.pop();
				stack2.push(x);
			}
		}
	}
	public int dequeue(){
		dump();
		if(!stack2.isEmpty())
			return stack2.pop();
		else return 0;
	
	}
	public int size(){
		return stack1.size()+stack2.size();
	}
	public int peek(){
		dump();
		if(!stack2.isEmpty())
			return stack2.peek();
		else return 0;
	}
	public static void main(String args[]){
		StacktoQueue sq=new StacktoQueue();
		sq.enqueue(1);sq.enqueue(2);sq.enqueue(3);sq.enqueue(4);
		System.out.println(sq.dequeue());
		sq.enqueue(5);
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		
	}
}