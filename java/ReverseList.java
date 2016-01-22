class ListNode {
 int val;
 ListNode next;
 ListNode(int x) { val = x; }
}
public class ReverseList {
	public void traverse(ListNode head){
		if(head==null)
			return;
		ListNode cur=head;
		while(cur!=null){
			System.out.print(cur.val+"->");
			cur=cur.next;
		}
	}
    public ListNode reverseList(ListNode head) {
		if (head==null)
			return null;
       ListNode dumpHead=new ListNode(0);
	   ListNode cur=head;
	   while(cur!=null){
		   ListNode temp=dumpHead.next;
		   ListNode t=cur.next;
		   dumpHead.next=cur;
		   cur.next=temp;
		   cur=t;
	   }
	   return dumpHead.next;
    }
	public ListNode reverseList2(ListNode head){
		if(head==null)
			return head;
		ListNode tail = null;
		ListNode cur = head;
		while(cur.next!=null){
			ListNode temp = cur.next;
			cur.next = tail;
			tail = cur;
			cur = temp;
		}
		cur.next = tail;
		return cur;
	}
	public ListNode reverseList3(ListNode head){
		if(head == null || head.next ==null){
			return head;
		}
		ListNode remaining = reverseList3(head.next);
		head.next.next = head;
		head.next = null;
		return remaining;
	}
	public static void main(String args[]){
		ReverseList rl= new ReverseList();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(6);
		ListNode l4=new ListNode(3);
		ListNode l5=new ListNode(4);
		ListNode l6=new ListNode(5);
		ListNode l7=new ListNode(6);
		l1.next=l2;l2.next=l3;l3.next=l4;
		l4.next=l5;l5.next=l6;l6.next=l7;
		rl.traverse(l1);
		System.out.println();
		rl.traverse(rl.reverseList3(l1));
	}
}