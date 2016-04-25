import java.util.*;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class ValidateBST{
	public boolean isValidBST(TreeNode root) {
	    return isValidBSTHelper(root, null, null);
	}
	private boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
	    if(root == null)
	        return true;

	    if(min != null && root.val <= min)
	        return false;

	    if(max != null && root.val >= max) 
	        return false;

	    if(!isValidBSTHelper(root.left, min, root.val) || 
	       !isValidBSTHelper(root.right, root.val, max))
	        return false;

	    return true;
	}
	
	public boolean isValidBST2(TreeNode root){
		if(root==null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		Integer min = null;
		while(!stack.isEmpty()){
			while(!stack.isEmpty() && stack.peek().left != null){
				stack.push(stack.peek().left);
			}
			while(!stack.isEmpty() && stack.peek().right==null){
				TreeNode cur = stack.pop();
				if(min!=null && cur.val <= min)
					return false;
				else min = cur.val;
			}
			if(!stack.isEmpty()){
				TreeNode cur = stack.pop();
				if(min!=null&& cur.val <= min)
					return false;
				else min = cur.val;
				stack.push(cur.right);
			
			}
		}
		return true;
	}
	public static void main(String args[]){
		ValidateBST vb=new ValidateBST();
		TreeNode root=new TreeNode(3);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(5);
		TreeNode t4=new TreeNode(4);
		// TreeNode t5=new TreeNode(1);
		root.left=t2;
		t2.left=t1;
		// t2.right=t5;
		root.right=t4;
		t4.right=t3;
		System.out.println(vb.isValidBST(root));
		System.out.println(vb.isValidBST2(root));
	}
}