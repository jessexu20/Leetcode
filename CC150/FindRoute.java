import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
class DirectedGraphNode {
     char label;
     List<DirectedGraphNode> directs;
     DirectedGraphNode(char x) {
		  label = x;
		  directs = new ArrayList<DirectedGraphNode>(); 
	  }
};
public class FindRoute{//4.2
	HashMap<DirectedGraphNode,Integer> map=new HashMap();
	public boolean isConnected(DirectedGraphNode start,DirectedGraphNode end){
		// System.out.println(start.label);
		boolean flag=false;
		if(start==end)
			return true;
		if(start.directs.size()==0)
			return flag;
		for(DirectedGraphNode node:start.directs){
			if(!map.containsKey(node)){
				map.put(node,1);
				flag= flag||isConnected(node,end);
			}
			if(flag==true)
				return flag;
		}
		return flag;
	}
	public static void main(String args[]){
		FindRoute fr= new FindRoute();
		DirectedGraphNode a=new DirectedGraphNode('a');
		DirectedGraphNode b=new DirectedGraphNode('b');
		DirectedGraphNode c=new DirectedGraphNode('c');
		DirectedGraphNode d=new DirectedGraphNode('d');
		DirectedGraphNode e=new DirectedGraphNode('e');
		a.directs.add(b);a.directs.add(e);
		c.directs.add(b);c.directs.add(d);
		d.directs.add(e);
		System.out.println(fr.isConnected(c,e));
		
	}
	
}