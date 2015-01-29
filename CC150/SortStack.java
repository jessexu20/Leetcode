import java.util.Stack;
public class SortStack{
	public Stack<Integer> unsortedStack;
	public Stack<Integer> sortedStack;
	public SortStack(int [] num){
		unsortedStack=new Stack();
		sortedStack=new Stack();
		for(int i:num)
			unsortedStack.push(i);
	}
	public void sort(){//3.6
		while(!unsortedStack.isEmpty()){
			int temp=unsortedStack.pop();
			if(sortedStack.isEmpty())
				sortedStack.push(temp);
			else{
				System.out.println(sortedStack);
				int count = 0;
				while(!sortedStack.isEmpty()&&temp>sortedStack.peek()){
					unsortedStack.push(sortedStack.pop());
					count++;
				}
				sortedStack.push(temp);
				for(int i=0;i<count;i++){
					sortedStack.push(unsortedStack.pop());
				}
			}
		}
		while(!sortedStack.isEmpty()){
			unsortedStack.push(sortedStack.pop());
		}
	}
	public static void main(String args[]){
		int [] num={3,6,1,4,5,2};
		SortStack ss= new SortStack(num);
		ss.sort();
	}
	
}