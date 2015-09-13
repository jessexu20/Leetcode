class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class RemoveList {
	public void traverse(ListNode head){
		if(head==null)
			return;
		ListNode cur=head;
		while(cur!=null){
			System.out.print(cur.val+"->");
			cur=cur.next;
		}
	}
    public ListNode removeElements(ListNode head, int val) {
		if(head==null)
			return null;
        ListNode dumpHead= new ListNode(1);
		dumpHead.next=head;
		ListNode cur=dumpHead;
		while(cur!=null){
			ListNode temp= cur.next;
			if(temp!=null && temp.val==val){
				cur.next=temp.next;
			}
			else if(temp==null){
				break;
			}
			else
				cur=temp;
				
		}
		return dumpHead.next;
    }
	public static void main(String args[]){
		RemoveList rl = new RemoveList();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(6);
		ListNode l4=new ListNode(3);
		ListNode l5=new ListNode(4);
		ListNode l6=new ListNode(5);
		ListNode l7=new ListNode(6);
		l1.next=l2;// l2.next=l3;l3.next=l4;
// 		l4.next=l5;l5.next=l6;l6.next=l7;
		rl.traverse(l1);
		System.out.println();
		rl.traverse(rl.removeElements(l1,1));
		
	}
}