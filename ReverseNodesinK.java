class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class ReverseNodesinK {
	public void traverse(ListNode head){
		ListNode cur=head;
		while(cur!=null){
			System.out.print(cur.val+"\t");
			cur=cur.next;
		}
	}
    public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null || k==0)
			return head;
		ListNode dumpHead=new ListNode(-Integer.MIN_VALUE);
		dumpHead.next=head;
		ListNode cur=head;
		ListNode nextNode=dumpHead;
		int count =1;
		while(cur!=null){
			cur=cur.next;
			count++;
			if(count==k && cur!=null){
				ListNode p=nextNode.next;
				ListNode tail=nextNode.next;
				ListNode q=p.next;
				while(p!=cur){
					System.out.println(p.val);
					ListNode tmp=q.next;
					q.next=p;
					p=q;
					q=tmp;
				}
				cur=q;
				count=1;
				tail.next=q;
				nextNode.next=p;
				nextNode=tail;
			}
		}	
		return dumpHead.next;
    }
	public static void main(String []args){
		ReverseNodesinK rn=new ReverseNodesinK();
		ListNode l0=new ListNode(0);
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l0.next=l1;
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		rn.traverse(rn.reverseKGroup(l0,4));
	}
}




/*
cur val: 1
cur val: 2
0
1
cur val: 4
cur val: 5
2
1
0
2
1
2
0
1
2
1
0

*/