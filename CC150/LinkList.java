import java.util.Stack;
import java.util.HashMap;
class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		val=x;
		next=null;
	}
	public ListNode(){
		val=Integer.MIN_VALUE;
		next=null;
	}
}
public class LinkList{
	public void traverse(ListNode head){
		if(head==null)
			return;
		ListNode cur=head;
		while(cur!=null){
			System.out.print(cur.val+"->");
			cur=cur.next;
		}
		System.out.println();
	}
	public void removeDuplicate(ListNode l1){//2.1
		HashMap<Integer,Integer> map=new HashMap();
		ListNode cur=l1;
		while(cur.next!=null){
			if(map.containsKey(cur.next.val)){
				System.out.println("hre");
				ListNode temp=cur.next.next;
				cur.next=temp;
			}
			else{
				map.put(cur.next.val,1);
			}
			cur=cur.next;
			System.out.println(map);
		}
	}
	public ListNode findKthLast(int k,ListNode head){//2.2
		ListNode c1=head;ListNode c2=head;
		for(int i=0;i<k;i++){
			if(c1!=null)
				c1=c1.next;
			else return null;
		}
		while(c1!=null){
			c1=c1.next;
			c2=c2.next;
		}
		return c2;
	}
	public void deleteNode(ListNode d){//2.3
		if(d==null)
			return;
		ListNode temp=d.next;
		ListNode t=temp.next;
		d.val=temp.val;
		d.next=t;
		return;
	}
	public ListNode partition(int value,ListNode head){//2.4
		ListNode sHead=new ListNode();ListNode bHead=new ListNode();ListNode eHead=new ListNode();
		ListNode cur=head;ListNode curS=sHead;ListNode curB=bHead;ListNode curE=eHead;
		while(cur!=null){
			if(cur.val<value){
				curS.next=cur;
				curS=curS.next;
			}
				
			else if(cur.val==value){
				curE.next=cur;
				curE=curE.next;
			}
			else{
				curB.next=cur;
				curB=curB.next;
			}
			cur=cur.next;
		}
		curS.next=null;curB.next=null;curE.next=null;
		curS.next=eHead.next;
		curE.next=bHead.next;
		return sHead.next;
	}
	public ListNode addition(ListNode l1,ListNode l2){//2.5
		ListNode cur1=l1;ListNode cur2=l2;ListNode res=new ListNode();
		ListNode cur3=res;
		if(cur1==null && cur2==null)
			return null;
		int carry=0;
		while(cur1!=null && cur2!=null){
			cur3.next=new ListNode((cur1.val+cur2.val+carry)%10);
			carry=(cur1.val+cur2.val+carry)/10;
			cur1=cur1.next;
			cur2=cur2.next;
			cur3=cur3.next;
		}
		while(cur1!=null){
			cur3.next=cur1;
			cur3=cur3.next;
			cur1=cur1.next;
		}
		while(cur2!=null){
			cur3.next=cur2;
			cur3=cur3.next;
			cur2=cur2.next;
		}
		return res.next;
	}
	// public ListNode additionEX(ListNode l1,ListNode l2){//2.5 padding zeros
	// 	ListNode cur1=l1;ListNode cur2=l2;ListNode res=new ListNode(0);
	// 	ListNode cur3=res;
	// 	if(cur1==null && cur2==null)
	// 		return null;
	// 	int carry=0;
	// 	while(cur1!=null && cur2!=null){
	// 		carry=(cur1.val+cur2.val+carry)/10;
	// 		cur3.next=new ListNode((cur1.val+cur2.val+carry)%10);
	// 		cur1=cur1.next;
	// 		cur2=cur2.next;
	// 		cur3=cur3.next;
	// 	}
	// 	while(cur1!=null){
	// 		cur3.next=cur1;
	// 		cur3=cur3.next;
	// 		cur1=cur1.next;
	// 	}
	// 	while(cur2!=null){
	// 		cur3.next=cur2;
	// 		cur3=cur3.next;
	// 		cur2=cur2.next;
	// 	}
	// 	return res.next;
	// }
	public ListNode detectNode(ListNode l1){//2.6
		ListNode fast=l1;ListNode slow=l1;
		int loop=0;
		if(l1==null)
			return null;
		while(fast!=null && fast.next!=null){
			fast=fast.next;
			fast=fast.next;
			slow=slow.next;
			if(slow==fast)
				break;
			loop++;
		}
		if(fast==null ||fast.next==null)
			return null;
		slow=l1;
		System.out.println(loop);
		while(fast!=slow){
			fast=fast.next;
			slow=slow.next;
		}
		return fast;
	}
	public boolean isPalindrome(ListNode l1){//2.7
		Stack<ListNode> stack=new Stack();
		ListNode slow=l1;ListNode fast=l1;
		while(fast!=null&& fast.next!=null){
			stack.push(slow);
			fast=fast.next.next;
			slow=slow.next;
		}
		System.out.println(slow.val);
		if(fast!=null)
			slow=slow.next;
		while(!stack.isEmpty()&& slow!=null){
			ListNode t=stack.pop();
			if(t.val!=slow.val)
				return false;
			else slow=slow.next;
		}
		return true;
	}
	public static void main(String args[]){
		LinkList ll= new LinkList();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(3);
		ListNode l6=new ListNode(2);
		ListNode l7=new ListNode(1);
		l1.next=l2;l2.next=l3;l3.next=l5;
		l4.next=l5;
		l5.next=l6;l6.next=l7;
		ll.removeDuplicate(l1);
		ll.traverse(l1);
		// ListNode lastK=ll.findKthLast(2,l1);
		// ll.deleteNode(l5);
		// ListNode result=ll.partition(4,l1);
		// ll.traverse(result);
		// ll.traverse(l1);
		// ll.traverse(l4);
		// ListNode ress=ll.addition(l1,l4);
		// ll.traverse(ress);
		// ListNode lp=ll.detectNode(l1);
		// System.out.println(lp.val);
		// System.out.println(ll.isPalindrome(l1));
		
	}
}