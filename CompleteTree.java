public class CompleteTree {
	public TreeNode findLeaf(TreeNode root) {
		if (root == null)
			return null;
		if(root.left ==null && root.right ==null)
			return root;
		else if(root.left!=null && root.right==null)
			return root.left;
		else {
			if (height(root.left) > height(root.right)) {
				return findLeaf(root.left);
			}
			else return findLeaf(root.right);
		}
	}
	public int height(TreeNode root){
		if(root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	public static void main(String args[]){
		CompleteTree cTree = new CompleteTree();
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		root.left = node1;
		node1.left = node2;
		node1.right =node3;
		root.right = node4;
		node4.left = node5;
		node4.right = node6;
		node2.left = node7;
		node2.right = node8;
		node3.left = node9;
		node3.right = node10;
		node5.left = node11;
		node5.right = node12;
		node6.left = node13;
		node6.right = node14;
		System.out.println(cTree.findLeaf(root).val);
		
	}
}
