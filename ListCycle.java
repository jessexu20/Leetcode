import java.util.*;
class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
public class ListCycle{
	public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> map= new HashMap();
		ListNode cur=head;
		while(cur!=null){
			if(!map.containsKey(cur))
				map.put(cur,cur.val);
			else
				break;
			cur=cur.next;
		}
		// System.out.println(map);
		return cur;
	}
	public static void main(String args[]){
		ListCycle lc=new ListCycle();
		ListNode l0=new ListNode(0);
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		l0.next=l1;l1.next=l2;l2.next=l3;l3.next=l4;
		l4.next=l5;l5.next=l6;
		// l6.next=l3;
		ListNode res=lc.detectCycle(l0);
		if(res!=null)
			System.out.println(res.val);
		else System.out.println("null");
	}
}