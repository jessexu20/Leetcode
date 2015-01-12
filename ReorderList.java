 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
		 val = x;
         next = null;
     }
 }
public class ReorderList{
	public void traverse(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.print(cur.val);
			System.out.print("->");
			cur=cur.next;
		}
	}
	public ListNode reverse(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode cur=head.next;
		head.next=null;
		while(cur!=null){
			ListNode t=cur.next;
			cur.next=head;
			head=cur;
			cur=t;
		}
		return head;
	}

    public void reorderList(ListNode head) {
		if(head==null)
			return;
        ListNode current=head;
		int len=0;
		while(current!=null){
			len++;
			current=current.next;
		}
		current=head;
		int half=len/2+1;
		while(half>1){
			current=current.next;
			half--;
		}
		ListNode x= current.next;
		current.next=null;

		x=reverse(x);
		current=head;
		while(x!=null){
			ListNode t=current.next;
			ListNode y=x.next;
			current.next=x;
			x.next=t;
			current=t;
			x=y;
		}
		
    }
	public static void main(String args[]){
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		// ListNode l6=new ListNode(6);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		// l5.next=l6;
		ReorderList rl=new ReorderList();
		rl.reorderList(l1);
		rl.traverse(l1);
	}
}