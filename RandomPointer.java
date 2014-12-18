import java.util.HashMap;
class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };
public class RandomPointer {
	public void traverse(RandomListNode head){
		RandomListNode current=head;
		while(current!=null){
			System.out.print(current.label);
			if(current.random==null){
				System.out.print("(null)");
			}
			else{
				System.out.print("(");
				System.out.print(current.random.label);
				System.out.print(")");
			}
			System.out.print("->");
			current=current.next;
		}
		System.out.println();
	}
    public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)
			return null;
		HashMap <Integer,RandomListNode> hashmap=new HashMap();
        RandomListNode cpHead= new RandomListNode(head.label);
		RandomListNode current=head;
		RandomListNode cp= cpHead;
		while(current.next!=null){
			int value=current.next.label;
			if (hashmap.containsKey(value)){
				cp.next=hashmap.get(value);
			}
			else{
				RandomListNode temp=new RandomListNode(value);
				cp.next=temp;
				hashmap.put(value,temp);
			} 
			if(current.random==null)
				cp.random=null;
			else{
				int randValue=current.random.label;
				if(hashmap.containsKey(randValue)){
					cp.random=hashmap.get(randValue);
				}
				else{
					RandomListNode temp=new RandomListNode(randValue);
					cp.random=temp;
					hashmap.put(randValue,temp);
				}
			}
			
			current=current.next;
			cp=cp.next;
		}
		if(current.random==null)
			cp.random=null;
		else{
			int randValue=current.random.label;
			if(hashmap.containsKey(randValue)){
				cp.random=hashmap.get(randValue);
			}
			else{
				RandomListNode temp=new RandomListNode(randValue);
				cp.random=temp;
				hashmap.put(randValue,temp);
			}
		}
		return cpHead;
    }
	public static void main(String args[]){
		RandomPointer rp=new RandomPointer();
		RandomListNode head= new RandomListNode(0);
		RandomListNode r1= new RandomListNode(1);
		RandomListNode r2= new RandomListNode(2);
		RandomListNode r3= new RandomListNode(3);
		head.next=r1;r1.next=r2;r2.next=r3;
		head.random=r3;r1.random=null;r2.random=r3;r3.random=r1;
		RandomListNode ne=rp.copyRandomList(head);
		rp.traverse(head);
		rp.traverse(ne);
		
	}
}
