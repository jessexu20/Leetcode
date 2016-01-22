import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class LeafTree{
	public List<TreeNode> build(int n){
		List<List<TreeNode>> dp = new ArrayList<List<TreeNode>>();
		dp.add(null);
		List<TreeNode> temp = new ArrayList<TreeNode>();
		temp.add(new TreeNode(0));
		dp.add(temp);
		temp = new ArrayList<TreeNode>();
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		temp.add(t1);
		dp.add(temp);
		for(int i = 3;i <= n; i++){
			for(int j = 1; j < i; j++){
				List<TreeNode> left = dp.get(j);
				List<TreeNode> right = dp.get(i-j);
				if(dp.size()<i+1){
					dp.add(new ArrayList<TreeNode>());
				}
				TreeNode root = new TreeNode(0);
				for(TreeNode l: left){
					for(TreeNode r: right){
						root.left = l;
						root.right = r;
						dp.get(i).add(root);
					}
				}
			}
		}
		return dp.get(n);
	}
	public int count(int n){
		int [] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i <= n;i++){
			int count = 0;
			for(int j = 1; j < i; j++){
				count += dp[j]*dp[i-j];
			}
			dp[i] = count;
		}
		return dp[n];
	}
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null)
			return result;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		while(!que.isEmpty()){
			List<Integer> cur = new ArrayList<Integer>();
			int size = que.size();
			for(int i= 0; i<size;i++){
				TreeNode t = que.poll();
				if (t==null) {
					cur.add(null);
					continue;
				}
				cur.add(t.val);
				que.offer(t.left);
				que.offer(t.right);
			}
			result.add(cur);
		}
		return result;
		
	}
	public static void main(String args[]){
		LeafTree leaftree = new LeafTree();
		List<TreeNode> result = leaftree.build(10);
//		for(TreeNode root : result){
//			System.out.println(leaftree.levelOrder(root));
//		}
		System.out.println(result.size());
		System.out.println(leaftree.count(10));
	}
}