class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
public class DeleteNode {
    public void deleteNode(ListNode node) {
		ListNode temp=node.next;
		node.val=temp.val;
		node.next=temp.next;
    }
	public void traverse(ListNode head){
		if (head==null)
			return;
		ListNode cur= head;
		while(cur!=null){
			System.out.print(cur.val);
			System.out.print("->");
			cur=cur.next;
		}
	}
	public static void main(String args[]){
		DeleteNode dn =new DeleteNode();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		// ListNode l3=new ListNode(3);
		// ListNode l4=new ListNode(4);
		// ListNode l5=new ListNode(5);
		l1.next=l2;
		// l2.next=l3;
		// l3.next=l4;
		// l4.next=l5;
		dn.traverse(l1);
		System.out.println();
		dn.deleteNode(l2);
		dn.traverse(l1);
		
	}
}