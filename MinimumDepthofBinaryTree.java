package leetcode;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root==null) return 0;
		else if (root.left==null && root.right==null) return 1;
		else if (root.left==null && root.right!=null) return minDepth(root.right)+1;
		else if (root.left!=null && root.right==null) return minDepth(root.left)+1;
		else {
			return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		t1.left=t2;
		t1.right=t3;	
		t2.left=t4;
		t2.right=t5;

		MinimumDepthofBinaryTree mdbt=new MinimumDepthofBinaryTree();
		System.out.println(mdbt.minDepth(t1));
	}

}
