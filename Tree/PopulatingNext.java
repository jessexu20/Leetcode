import java.util.*;
class TreeLinkNode {
  int val;
  TreeLinkNode left, right, next;
  TreeLinkNode(int x) { val = x; }
}
public class PopulatingNext {
	public void connect(TreeLinkNode root) {
		List<List<TreeLinkNode>> nodes= new ArrayList();
		level(nodes,1,root);
		for(List<TreeLinkNode> list: nodes){
			for(int i=0;i<list.size()-1;i++){
				list.get(i).next=list.get(i+1);
			}
		}
	}
	public void level(List<List<TreeLinkNode>> list, int l, TreeLinkNode node){
		if(node==null)
			return;
		if(list.size()<l){
			list.add(new ArrayList<TreeLinkNode>());
			list.get(l-1).add(node);
		}
		else{
			list.get(l-1).add(node);
		}
		level(list,l+1,node.left);
		level(list,l+1,node.right);
	}
	public static void main(String args[]){
		PopulatingNext pn= new PopulatingNext();
		TreeLinkNode t1=new TreeLinkNode(1);
		TreeLinkNode t2=new TreeLinkNode(2);
		TreeLinkNode t3=new TreeLinkNode(3);
		TreeLinkNode t4=new TreeLinkNode(4);
		TreeLinkNode t5=new TreeLinkNode(5);
		TreeLinkNode t6=new TreeLinkNode(6);
		t1.left=t2;t2.left=t4;t2.right=t5;
		t1.right=t3;t3.left=t6;
		pn.connect(t1);
	}
}