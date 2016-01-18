package google;

import java.util.*;

class DirectedGraphNode{
	int label;
	List<DirectedGraphNode> neighbor;

	DirectedGraphNode(int x) {
		label = x;
		neighbor = new ArrayList<DirectedGraphNode>();
	}
};

class DirectedGraphEdge {
	DirectedGraphNode from;
	DirectedGraphNode to;

	DirectedGraphEdge(DirectedGraphNode x, DirectedGraphNode y) {
		from = x;
		to = y;
	}
}

public class RemoveEdge {
	public void printBackEdge(DirectedGraphNode node) {
		Set<DirectedGraphNode> set = new HashSet<>();
		Set<DirectedGraphEdge> result = new HashSet<>();
		dfs(node, null, set, result);
		for(DirectedGraphEdge edge: result){
			System.out.println("edge from " + edge.from.label + " to " + edge.to.label );
		}
		
	}

	public void dfs(DirectedGraphNode node, DirectedGraphNode prev, Set<DirectedGraphNode> visited, Set<DirectedGraphEdge> result) {
		if (visited.add(node)) {
			for (DirectedGraphNode n : node.neighbor) {
				Set<DirectedGraphNode> temp = new HashSet<>(visited);
				dfs(n, node, temp, result);
			}
		} else
			result.add(new DirectedGraphEdge(prev, node));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedGraphNode node1 = new DirectedGraphNode(1);
		DirectedGraphNode node2 = new DirectedGraphNode(2);
		DirectedGraphNode node3 = new DirectedGraphNode(3);
		DirectedGraphNode node4 = new DirectedGraphNode(4);
		DirectedGraphNode node5 = new DirectedGraphNode(5);
		node1.neighbor.add(node2);
		node1.neighbor.add(node4);
		node2.neighbor.add(node3);
		node4.neighbor.add(node3);
		node4.neighbor.add(node5);
		node5.neighbor.add(node1);
		node5.neighbor.add(node2);
		RemoveEdge removeEdge = new RemoveEdge();
		removeEdge.printBackEdge(node1);
		
		
		
	}

}
