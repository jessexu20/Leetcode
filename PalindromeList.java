import java.util.Stack;
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
		if (head==null)
			return true;
		Stack <Integer> stack=new Stack();
		int len=0;
		ListNode current=head;
		ListNode temp=head;
		while(temp.next!=null){
			stack.push(current.val);
			current=current.next;
			temp=temp.next;
			len++;
			if(temp.next!=null){
				temp=temp.next;
				len++;
			}
		}
		len++;
		if(stack.size()==1&&current.next==null){
			return stack.peek()==current.val;
		}
		
		if(len%2!=0)
			current=current.next;
		while(!stack.isEmpty()){
			int t=stack.pop();
			if(current==null || current.val!=t)
				return false;
			current=current.next;
		}
        return true;
    }
	public static void main(String args[]){
		PalindromeList pl=new PalindromeList();
		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(2);
		// ListNode l3= new ListNode(3);
		ListNode l4= new ListNode(2);
		ListNode l5= new ListNode(1);
		l1.next=l2;
		// l2.next=l3;
		l2.next=l4;
		l4.next=l5;
		System.out.println(pl.isPalindrome(l1));
	}
}