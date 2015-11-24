import java.util.*;
class NaryTreeNode{
	int val;
	List<NaryTreeNode> children;
	NaryTreeNode(int x){
		val = x;
		children = new ArrayList<NaryTreeNode>();
	}
}
public class NaryTree{
	public String serialize(NaryTreeNode root){
		StringBuilder sb = new StringBuilder();
		if(root == null){
			sb.append(';');
			return sb.toString();
		}
		Queue<NaryTreeNode> que = new LinkedList();
		que.offer(root);
		sb.append(root.val);
		sb.append(';');//* is level 
		while(!que.isEmpty()){
			int size = que.size();
			for(int i = 0;i < size;i++){
				NaryTreeNode cur = que.poll();
				for(NaryTreeNode t : cur.children){
					que.offer(t);
					sb.append(t.val);
					sb.append(' ');
				}
				sb.setCharAt(sb.length()-1,'#');//# is node interval
			}
			sb.setCharAt(sb.length()-1,';');
		}
		return sb.toString();
	}
	//0*1 2 3*4 5#6#7 8 9*
	public NaryTreeNode recover(String str){
		String [] levels = str.split(";");
		NaryTreeNode root = null;
		Queue<NaryTreeNode> que = new LinkedList();
		for(int i = 0; i <levels.length; i++){
			if(que.isEmpty()){
				int num = Integer.valueOf(levels[0]);
				NaryTreeNode t = new NaryTreeNode(num);
				root = t;
				que.offer(t);
				continue;
			}
			String [] nodes = levels[i].split("#");
			for(int j = 0; j < nodes.length; j++){
				NaryTreeNode cur = que.poll();
				String [] n = nodes[j].split(" ");
				for(int k = 0; k <n.length;k++){
					int num = Integer.valueOf(n[k]);
					NaryTreeNode t = new NaryTreeNode(num);
					cur.children.add(t);
					que.offer(t);
				}
			}
		}
		return root;
	}
	public static void main(String args[]){
		NaryTree tree = new NaryTree();
		NaryTreeNode root = new NaryTreeNode(0);
		NaryTreeNode n1 = new NaryTreeNode(1);
		
		NaryTreeNode n2 = new NaryTreeNode(2);
		NaryTreeNode n3 = new NaryTreeNode(3);
		NaryTreeNode n4 = new NaryTreeNode(4);
		
		NaryTreeNode n5 = new NaryTreeNode(5);
		NaryTreeNode n6 = new NaryTreeNode(6);
		NaryTreeNode n7 = new NaryTreeNode(7);
		NaryTreeNode n8 = new NaryTreeNode(8);
		NaryTreeNode n9 = new NaryTreeNode(9);
		root.children.add(n1);
		root.children.add(n2);
		root.children.add(n3);
		n1.children.add(n4);
		n1.children.add(n5);
		n2.children.add(n6);
		n3.children.add(n7);
		n3.children.add(n8);
		n3.children.add(n9);
		String str = tree.serialize(root);
		NaryTreeNode r = tree.recover(str);
		System.out.println(tree.serialize(r));
	}
}