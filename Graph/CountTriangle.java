import java.util.*;
class Node{
	char name;
	Set<Node> neighbors;
	Node(char x){
		name = x;
		neighbors = new HashSet<Node>();
	}
	public String toString(){
		return String.valueOf(name);
	}
}
public class CountTriangle{
	public int count(List<Node> list){
		int cnt = 0;
		for(Node node: list){
			Set<Node> two = new HashSet<>(node.neighbors);
			for(Node n: two){
				Set<Node> three = n.neighbors;
				for(Node x: three){
					if(x==node) continue;
					if(node.neighbors.contains(x)){
						cnt++;
						System.out.print(cnt);
						System.out.print(node);
						System.out.print(n);
						System.out.println(x);
					}
						
				}
				node.neighbors.remove(n);
				n.neighbors.remove(node);
				// check(list);
			}
		}
		return cnt;

	}
	public void check(List<Node> list){
		for(Node n: list){
			System.out.print(n+":");
			System.out.println(n.neighbors);
		}
	}
	public static void main(String args[]){
		Node a = new Node('a');
		Node b = new Node('b');
		Node c = new Node('c');
		Node d = new Node('d');
		Node e = new Node('e');
		Node f = new Node('f');
		a.neighbors.add(b);
		a.neighbors.add(c);
		a.neighbors.add(d);
		b.neighbors.add(a);
		b.neighbors.add(c);
		b.neighbors.add(f);
		c.neighbors.add(a);
		c.neighbors.add(b);
		c.neighbors.add(d);
		c.neighbors.add(e);
		d.neighbors.add(a);
		d.neighbors.add(a);
		d.neighbors.add(c);
		d.neighbors.add(e);
		e.neighbors.add(c);
		e.neighbors.add(d);
		e.neighbors.add(f);
		f.neighbors.add(b);
		f.neighbors.add(e);
		
		CountTriangle ct = new CountTriangle();
		List<Node> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);
		ct.check(list);
		System.out.println(ct.count(list));
		
		
	}

}