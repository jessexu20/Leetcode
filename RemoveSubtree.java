class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
public class RemoveSubtree{
	public int removeSubTree(TreeNode root){
		if(root == null)
			return 0;
		int left = removeSubTree(root.left);
		int right = removeSubTree(root.right);
		int sum = left+right+root.val;
		if( sum < 0){
			root.left = null;
			root.right = null;
			return root.val;
		}
		else return sum;
	}
	public static void main(String args[]){
		RemoveSubtree rst = new RemoveSubtree();
		TreeNode root = new TreeNode(0);
		TreeNode t1 = new TreeNode(-1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(-1);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(-2);
		root.left = t1;
		root.right = t4;
		t1.left = t2;
		t1.right = t3;
		t4.right = t5;
		rst.removeSubTree(root);
	}
}