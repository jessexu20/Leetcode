package google;

import java.util.*;

class DirectedEdge {
	String src;
	String dst;

	DirectedEdge(String x, String y) {
		src = x;
		dst = y;
	}
}

class Node {
	String label;
	List<Node> neighbors;

	Node(String x) {
		label = x;
		neighbors = new ArrayList<Node>();
	}

	@Override
	public int hashCode() {
		return label.hashCode();
	}
	@Override
	public String toString() {
		return label;
	}
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
}

public class DirectedCycle {

	public boolean consistent(DirectedEdge[] edges) {
		HashMap<Node, Integer> indegree = new HashMap<>();
		HashMap<String, Node> mapping = new HashMap<>();
		for (DirectedEdge e : edges) {
			Node dst = (mapping.containsKey(e.dst))? mapping.get(e.dst) : new Node(e.dst);
			Node src = (mapping.containsKey(e.src))? mapping.get(e.src) : new Node(e.src);
			mapping.put(e.dst,dst);
			mapping.put(e.src,src);
			mapping.get(e.src).neighbors.add(dst);
			if (!indegree.containsKey(dst))
				indegree.put(dst, 0);
			indegree.put(dst, indegree.get(dst) + 1);
		}
		mapping.values().removeAll(indegree.keySet());
		Queue<Node> que = new LinkedList<>();
		que.addAll(mapping.values());
		while (!que.isEmpty()) {
			Node cur = que.poll();
			for (Node n : cur.neighbors) {
				indegree.put(n, indegree.get(n) - 1);
				if (indegree.get(n) == 0) {
					indegree.remove(n);
					que.offer(n);
				}
			}
		}
		return indegree.size() == 0;
	}
	public static void main(String args[]){
		DirectedEdge edge1 = new DirectedEdge("a", "b");
		DirectedEdge edge2 = new DirectedEdge("b", "c");
		DirectedEdge edge3 = new DirectedEdge("a", "c");
		DirectedEdge edge4 = new DirectedEdge("c", "d");
		DirectedEdge edge5 = new DirectedEdge("d", "b");
		DirectedEdge [] edges = {edge1,edge2,edge3,edge4,edge5};
		DirectedCycle topoSort = new DirectedCycle();
		System.out.println(topoSort.consistent(edges));
	}
}
