class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}

public class SortList {
	public void traverse(ListNode head){
		System.out.println();
		ListNode current=head;
		while(current!=null){
			System.out.print(current.val);
			System.out.print("->");
			current=current.next;
		}
	}
	public ListNode merge(ListNode h1,ListNode h2){
		if(h1==null && h2==null){
			return null;
		}
		else if(h1==null){
			return h2;
		}
		else if(h2==null){
			return h1;
		}
		else{
			ListNode cur1;ListNode cur2;
			ListNode newHead=new ListNode(-1);ListNode cur;
			cur1=h1;cur2=h2;cur=newHead;
			while(cur1!=null && cur2!=null){
				if(cur1.val>cur2.val){
					ListNode t=cur2.next;
					cur.next=cur2;
					cur=cur.next;
					cur2=t;
				}
				else{
					ListNode t=cur1.next;
					cur.next=cur1;
					cur=cur.next;
					cur1=t;
				}
			}
			while(cur2!=null){
				cur.next=cur2;
				cur=cur.next;
				cur2=cur2.next;
			}
			while(cur1!=null){
				cur.next=cur1;
				cur=cur.next;
				cur1=cur1.next;
			}
			return newHead.next;
		}
		
	}
	public ListNode sortList(ListNode head){
		ListNode current=head;
		if(current==null)
			return current;
		if(current.next==null)
			return current;
		ListNode oddHead=current;
		ListNode evenHead=current.next;
		ListNode odd=oddHead;
		ListNode even=evenHead;
		while(even!=null&&odd!=null){
			ListNode temp=even.next;
			odd.next=temp;
			if(temp!=null)
				even.next=temp.next;
			odd=temp;
			if(temp!=null)
				even=temp.next;
			else
				even.next=null;
		}		//
		// traverse(oddHead);
		// traverse(evenHead);
		ListNode newOddHead=sortList(oddHead);
		ListNode newEvenHead=sortList(evenHead);
		ListNode newHead=merge(newOddHead,newEvenHead);
		return newHead;
	}
	public static void main(String args[]){
		SortList sl=new SortList();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		ListNode l7=new ListNode(7);
		ListNode l8=new ListNode(8);
		ListNode l0=new ListNode(0);
		l1.next=l5;l5.next=l2;l2.next=l8;l8.next=l7;
		l7.next=l3;l3.next=l4;l4.next=l6;l6.next=l0;
		// sl.traverse(l1);
		ListNode newHead=sl.sortList(l1);
		// sl.traverse(newHead);
	}
}