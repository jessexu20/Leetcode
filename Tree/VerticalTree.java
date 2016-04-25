import java.util.*;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class VerticalTree{
	int min = 0;
	List<Integer> verticalTraverse(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root==null){
			return result;
		}
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		helper(map,root,0);
		for(int i = min; map.containsKey(i);i++){
			result.addAll(map.get(i));
		}
		return result;
	}
	public void helper(HashMap<Integer,List<Integer>> map, TreeNode node,int level){
		min = Math.min(min,level);
		if(!map.containsKey(level))
			map.put(level,new ArrayList<Integer>());
		map.get(level).add(node.val);
		if(node.left!=null)
			helper(map,node.left,level-1);
		if(node.right!=null)
			helper(map,node.right,level+1);
	}
	public static void main(String args[]){
		VerticalTree vb=new VerticalTree();
		TreeNode root=new TreeNode(3);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(0);
		TreeNode t4=new TreeNode(4);
		// TreeNode t5=new TreeNode(1);
		root.left=t2;
		t2.left=t1;
		// t2.right=t5;
		root.right=t4;
		t4.left=t3;
		System.out.println(vb.verticalTraverse(root));
	}
}