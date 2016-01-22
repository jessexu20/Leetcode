import java.util.List;
import java.util.ArrayList;
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class MergeKList{
	public void traverse(ListNode head){
		if(head==null)
			return;
		ListNode cur=head;
		while(cur!=null){
			System.out.print(cur.val);
			System.out.print("->");
			cur=cur.next;
		}
		System.out.println();
	}
	public ListNode mergeLists(ListNode l1,ListNode l2){
		if(l1==null && l2==null)
			return null;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode cur1=l1;ListNode cur2=l2;
		ListNode head=new ListNode(-100000);
		ListNode cur=head;
		while(cur1!=null && cur2!=null){
			if(cur1.val<=cur2.val){
				cur.next=cur1;
				cur1=cur1.next;
				cur=cur.next;
			}
			else{
				cur.next=cur2;
				cur2=cur2.next;
				cur=cur.next;
			}
		}
		while(cur1!=null){
			cur.next=cur1;
			cur1=cur1.next;
			cur=cur.next;
		}
		while(cur2!=null){
			cur.next=cur2;
			cur2=cur2.next;
			cur=cur.next;
		}
		return head.next;
	}
	public ListNode mergeKLists(List<ListNode> lists) {
		int length=lists.size();
		if(length==0)
			return null;
		while(length>1){
			ListNode res=mergeLists(lists.get(0),lists.get(1));
			lists.remove(0);
			lists.remove(0);
			lists.add(res);
			length=lists.size();
		}
		return lists.get(0);
	}
	public static void main(String args[]){
		MergeKList mk= new MergeKList();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		ListNode l7=new ListNode(7);
		ListNode l8=new ListNode(8);
		ListNode l9=new ListNode(9);
		ListNode l10=new ListNode(10);
		ListNode l11=new ListNode(11);
		l1.next=l2;l2.next=l4;
		l3.next=l5;
		l6.next=l8;l8.next=l11;
		l7.next=l9;l9.next=l10;
		List<ListNode> lists=new ArrayList();
		lists.add(l1);
		lists.add(l3);
		lists.add(l6);
		lists.add(l7);
		ListNode head=mk.mergeKLists(lists);
		mk.traverse(head);
	}
}