package leetcode;

import java.util.Stack;

public class MinStack {
	private java.util.Stack<Integer> stack=new Stack<Integer>();
	private int min=Integer.MAX_VALUE;
	public void push(int x) {
		if (x<this.min) {
			this.min=x;
		}
        stack.push(x);
    }
    public void pop() {
    	if (this.top()==this.min) {
    		stack.pop();
    		this.min=Integer.MAX_VALUE;
        	for (Integer integer : stack) {
    			if (integer<this.min) {
    				this.min=integer;
    			}
    		}
		}
    	else
    		stack.pop();
    }

    public int top() {
		return stack.peek();
        
    }

    public int getMin() {
		return this.min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack=new MinStack();
		minStack.push(2);
		minStack.push(0);
		minStack.push(3);
		minStack.push(0);
//		minStack.push(5);
//		minStack.push(6);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();		
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
	}

}
