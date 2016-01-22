import java.util.*;
class DoubleLinkedNode{
	int val;
	DoubleLinkedNode prev;
	DoubleLinkedNode next;
	DoubleLinkedNode(int x){
		this.val = x;
		prev = null;
		next = null;
	}
}
public class DivideComponents{
	public List<String> decide(List<DoubleLinkedNode> nodes){
		if(nodes.size()<1) return new ArrayList<String>();
		Set<DoubleLinkedNode> set = new HashSet();
		List<String> result = new ArrayList<String>();
		set.addAll(nodes);
		int i = 0;
		while(i < nodes.size()){
			DoubleLinkedNode temp = nodes.get(i);
			String str = set.contains(temp)?""+temp.val:"";
			set.remove(temp);
			while(temp.next!=null && set.contains(temp.next)){
				temp = temp.next;
				str += temp.val;
				set.remove(temp);
			}
			temp = nodes.get(i++);
			while(temp.prev!=null && set.contains(temp.prev)){
				
				temp = temp.prev;
				str += temp.val;
				set.remove(temp);
			}
			if(str.length()==0) continue;
			result.add(str);
		}
		return result;
	}
	public static void main(String args[]){
		DivideComponents dc = new DivideComponents();
		DoubleLinkedNode d1 = new DoubleLinkedNode(1);
		DoubleLinkedNode d2 = new DoubleLinkedNode(2);
		DoubleLinkedNode d3 = new DoubleLinkedNode(3);
		DoubleLinkedNode d4 = new DoubleLinkedNode(4);
		DoubleLinkedNode d5 = new DoubleLinkedNode(5);
		d1.next = d2; d2.prev = d1;
		d2.next = d3; d3.prev = d2;
		d3.next = d4; d4.prev = d3;
		d4.next = d5; d5.prev = d4;
		List<DoubleLinkedNode> list = new ArrayList();
		list.add(d1);list.add(d5);list.add(d4);
		System.out.println(dc.decide(list));
	}
}