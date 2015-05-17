import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) {
		  label = x;
		  neighbors = new ArrayList<UndirectedGraphNode>(); 
	  }
};
public class CloneGraph{
	public void clone(UndirectedGraphNode node,UndirectedGraphNode newNode,HashMap<Integer,UndirectedGraphNode> visit){
		if(visit.containsKey(newNode.label))
			return;
		visit.put(newNode.label,newNode);
		for(UndirectedGraphNode u:node.neighbors){
			if(visit.containsKey(u.label)){
			    newNode.neighbors.add(visit.get(u.label));
			    clone(u,visit.get(u.label),visit);
			}
			else{
			    UndirectedGraphNode t=new UndirectedGraphNode(u.label);
		    	newNode.neighbors.add(t);
		    	clone(u,t,visit);
			}
		}
	}
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
		UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
        HashMap<Integer,UndirectedGraphNode> visited=new HashMap();
		clone(node,newNode,visited);
		return newNode;
    }
	public static void main(String args[]){
		UndirectedGraphNode g0=new UndirectedGraphNode(0);
		UndirectedGraphNode g1=new UndirectedGraphNode(1);
		UndirectedGraphNode g2=new UndirectedGraphNode(2);
		g0.neighbors.add(g1);g0.neighbors.add(g2);
		g1.neighbors.add(g2);
		g1.neighbors.add(g2);
		CloneGraph cg=new CloneGraph();
		UndirectedGraphNode clone=cg.cloneGraph(g0);
		
		
	}
}