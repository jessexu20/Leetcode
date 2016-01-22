import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class CutMaxTree {
    public int minCut(TreeNode root) {
        List<Integer> result= new ArrayList<Integer>();
		int sum = helper(root,result);
		int min = Integer.MAX_VALUE;
		for(int i :result){
			int abs= Math.abs(sum-i-i);
			if(abs<min) min =abs; 
		}
		return min;
    }
	public int helper(TreeNode root, List<Integer> res ){
		if(root==null) return 0;
		int count=helper(root.left,res)+ helper(root.right,res)+root.val;
		res.add(count);
		return count;
	}
	public static void main(String args[]) {
		CutMaxTree cmt = new CutMaxTree();
		TreeNode root=new TreeNode(4);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		TreeNode t0=new TreeNode(0);
		root.left=t1;
		t1.left=t2;
		t1.right=t3;
		root.right=t6;
		t6.right=t7;
		t3.left=t0;
		System.out.println(cmt.minCut(root));
	}
}