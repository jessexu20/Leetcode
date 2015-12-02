class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
public class MergesortLinkedList{
	public ListNode sort(ListNode head){
		if(head == null || head.next==null)
			return head;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			
		} 
		ListNode right = sort(slow.next);
		slow.next = null;
		ListNode left = sort(head);
		return merge(left,right);
	}
	public ListNode merge(ListNode left, ListNode right){
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy, cur1 =left, cur2= right;
		while(cur1!=null && cur2!=null){
			if(cur1.val > cur2.val){
				cur.next = cur2;
				cur2 = cur2.next;
				cur = cur.next;
			}
			else{
				cur.next = cur1;
				cur1 = cur1.next;
				cur = cur.next;
			}
		}
		if(cur1==null){
			cur.next = cur2;
		}
		else if (cur2==null){
			cur.next = cur1;
		}
		return dummy.next;
	}
	public static void main(String args[]){
		MergesortLinkedList mll = new MergesortLinkedList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l3.next = l4;
		l4.next = l1;
		l1.next = l5;
		l5.next = l2;
		ListNode result = mll.sort(l3);
		ListNode cur = result;
		while(cur!=null){
			System.out.print(cur.val + "\t");
			cur = cur.next;

		}
		
	}
}