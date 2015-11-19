import java.util.*;
class TreeNode{
	int pid;
	int id;
	int val;
	TreeNode(int x,int i,int p){
		id = i;
		pid = p;
		val = x;
	}
}
public class SubTreeSum{
	HashMap<Integer, List<TreeNode>> map = new HashMap();
	public List<Integer> subtreeSum(TreeNode[] nodes){
		TreeNode root=null;
		for(TreeNode node: nodes){
			if(node.pid == -1){
				root = node;
				continue;
			}
			if(!map.containsKey(node.pid))
				map.put(node.pid, new ArrayList<TreeNode>());
			map.get(node.pid).add(node);
		}
		List<Integer> result = new ArrayList();
		for(TreeNode t : map.get(root.id)){
			helper(t,result);
		}
		return result;
	}
	public int helper(TreeNode root, List<Integer> result){
		List<TreeNode> nodes= map.get(root.id);
		int sum = root.val;
		if(nodes==null || nodes.size()==0) return sum;
		for(TreeNode t: nodes){
			sum += helper(t,result);
		}
		result.add(sum);
		return sum;
	}
	public static void main(String args[]){
		SubTreeSum ss = new SubTreeSum();
		TreeNode t1 = new TreeNode(1,1,-1);
		TreeNode t2 = new TreeNode(2,2,1);
		TreeNode t3 = new TreeNode(3,3,1);
		TreeNode t4 = new TreeNode(4,4,2);
		TreeNode t5 = new TreeNode(5,5,2);
		TreeNode t6 = new TreeNode(6,6,3);
		TreeNode[] nodes = {t1,t2,t3,t4,t5,t6};
		System.out.println(ss.subtreeSum(nodes));
	}
}