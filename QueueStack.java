import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
	Queue<Integer> que1=new LinkedList<Integer>();
	Queue<Integer> que2=new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        if (que1.isEmpty()) {
			que2.add(x);
		}
        else {
			que1.add(x);
		}
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (que1.isEmpty()) {
			while (que2.size()>1) {
				que1.add(que2.poll());
			}
			que2.poll();
		}
        else {
			while (que1.size()>1) {
				que2.add(que1.poll());
			}
			que1.poll();
		}
    }

    // Get the top element.
	public int top() {
		if (empty()) {
			return 0;
		}
		if (que1.isEmpty()) {
			while (que2.size() > 1) {
				que1.add(que2.poll());
			}
			int temp = que2.poll();
			que1.add(temp);
			return temp;
		} else {
			while (que1.size() > 1) {
				que2.add(que1.poll());
			}
			int temp = que1.poll();
			que2.add(temp);
			return temp;
		}

	}

    // Return whether the stack is empty.
    public boolean empty() {
		return que1.isEmpty() && que2.isEmpty();
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueStack myStack=new QueueStack();
		System.out.println(myStack.empty());
		myStack.push(1);
//		System.out.println(myStack.empty());
		myStack.push(2);
	}

}
