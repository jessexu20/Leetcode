import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class ConstructTree2 {
	public void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val+"\t");
		preOrder(root.left);
		preOrder(root.right);
		
	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val+"\t");
		inOrder(root.right);

	}
	public TreeNode constructTree(int [] preorder, int [] inorder){
		Stack <TreeNode> stack = new Stack();
		if(preorder.length<1) return null;
		int i = 0,j = 0;
		TreeNode root = new TreeNode (preorder[i++]);
		stack.push(root);
		TreeNode pre = null;
		while(j<inorder.length){
			//end of left tree
			if(!stack.isEmpty() && stack.peek().val== inorder[j]){
				pre = stack.pop();
				j++;
			}
			else if(pre!=null){//right child
				TreeNode r = new TreeNode(preorder[i++]);
				pre.right= r;
				stack.push(r);
				pre=null;
			}
			else{//left child
				TreeNode l = new TreeNode(preorder[i++]);
				stack.peek().left= l;
				stack.push(l);
			}
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructTree2 ct2=new ConstructTree2();
		int[] preorder = { 5, 3, 2, 1,6,7 };
		int[] inorder = {2,3,1,5,7,6 };
		TreeNode root=ct2.constructTree(preorder, inorder);
		ct2.preOrder(root);
		System.out.println();
		ct2.inOrder(root);
	}

}
