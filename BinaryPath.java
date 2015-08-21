import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class BinaryPath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result= new ArrayList<String> ();
		String res="";
		dfs(root,res,result);
		return result;
    }
	private void dfs(TreeNode root,String res,List<String> result){
		if(root==null)
			return;
		if(root.left==null && root.right==null){
			res=res+"->"+root.val;
			if(!result.contains(res))
				result.add(res.substring(2));
			return;
		}

		String temp= res+"->"+root.val;
		dfs(root.left,temp,result);
		dfs(root.right,temp,result);
	}
	public static void main(String args[]){
		BinaryPath bp= new BinaryPath();
		TreeNode root= new TreeNode(1);
		TreeNode t2= new TreeNode(2);
		TreeNode t3= new TreeNode(3);
		TreeNode t4= new TreeNode(4);
		TreeNode t5= new TreeNode(5);
		root.left=t2;
		root.right=t3;
		t2.right=t5;
		System.out.println(bp.binaryTreePaths(root));
	}
}