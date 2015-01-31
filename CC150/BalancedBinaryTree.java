package leetcode;

public class BalancedBinaryTree {//4.1
	public int subTreeLength(TreeNode root) {
		if (root==null) {
			return 0;
		}
		else{
			return Math.max(subTreeLength(root.left)+1, subTreeLength(root.right)+1);
		}
	}
    public boolean isBalanced(TreeNode root) {
    	if (root==null) {
			return true;
		}
    	else{
			if (Math.abs(subTreeLength(root.left)-subTreeLength(root.right))>1) {
				return false;
			}
			else {
				return (isBalanced(root.left) && isBalanced(root.right));
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		TreeNode t8=new TreeNode(8);
		TreeNode t9=new TreeNode(9);
		TreeNode t10=new TreeNode(10);
		TreeNode t11=new TreeNode(11);
		TreeNode t12=new TreeNode(12);
		TreeNode t13=new TreeNode(13);
		TreeNode t14=new TreeNode(14);
		TreeNode t15=new TreeNode(15);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t4.left=t8;
		t4.right=t9;
		t5.left=t10;
		t5.right=t11;
		t6.left=t12;
		t6.right=t13;
		t8.left=t14;

		BalancedBinaryTree tree=new BalancedBinaryTree();
		System.out.println(tree.isBalanced(t1));
	}

}
