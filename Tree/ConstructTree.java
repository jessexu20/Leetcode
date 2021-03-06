import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class ConstructTree {
	public void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val+"\t");
	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val+"\t");
		inOrder(root.right);

	}
	public TreeNode constructTree(int [] postorder , int [] inorder){
		Stack<TreeNode> stack = new Stack();
		int i = postorder.length-1, j = inorder.length-1;
		if(postorder.length<1) return null;
		TreeNode root = new TreeNode(postorder[i--]);
		stack.push(root);
		TreeNode pre=null;
		while(j>=0 && i >= 0){
			//root
			if(!stack.isEmpty() && stack.peek().val==inorder[j]){
				pre = stack.pop();
				j--;
			}
			//left child
			else if (pre!=null){
				TreeNode t = new TreeNode(postorder[i--]);
				pre.left=t;
				pre =null;
				stack.push(t);
			}
			else{
				//right child
				TreeNode t = new TreeNode(postorder[i--]);
				stack.peek().right= t;
				stack.push(t);
			}
		}
		return root;
	}


	public static void main(String args[]) {
		ConstructTree cons = new ConstructTree();
		int[] inorder = {5,2,9,6,1,7,4,8};
		int[] postorder = { 5,9,6,2,7,8,4,1};
		TreeNode tree = cons.constructTree(postorder,inorder );
		cons.inOrder(tree);
		System.out.println();
		cons.postOrder(tree);
	}
}