import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class Intersection{
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashMap <ListNode,Integer>hashmap=new HashMap();
		ListNode currentA=headA;
		ListNode currentB=headB;
		while(currentA!=null){
			hashmap.put(currentA,1);
			currentA=currentA.next;
		}
		while(currentB!=null){
			if(hashmap.containsKey(currentB)){
				return currentB;
			}
			currentB=currentB.next;
		}
		System.out.println(hashmap);
		System.out.println("abc");
        return null;
	}
	public static void main(String args[]){
		Intersection inter= new Intersection();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		ListNode l7=new ListNode(7);
		ListNode l8=new ListNode(8);
		l1.next=l2;l2.next=l6;
		l6.next=l7;l7.next=l8;
		l3.next=l4;l4.next=l5;l5.next=l6;
		System.out.println(inter.getIntersectionNode(l1,l3));
	}
}