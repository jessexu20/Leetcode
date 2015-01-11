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

	int pInorder; // index of inorder array
	int pPostorder; // index of postorder array
	private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
		if (pPostorder < 0) {
			return null;
		}

		// create root node
		TreeNode n = new TreeNode(postorder[pPostorder--]);

		// if right node exist, create right subtree
		if (inorder[pInorder] != n.val) {
			n.right = buildTree(inorder, postorder, n);
		}

		pInorder--;

		// if left node exist, create left subtree
		if ((end == null) || (inorder[pInorder] != end.val)) {
			n.left = buildTree(inorder, postorder, end);
		}

		return n;
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		pInorder = inorder.length - 1;
		pPostorder = postorder.length - 1;

		return buildTree(inorder, postorder, null);
	}
	public static void main(String args[]) {
		ConstructTree cons = new ConstructTree();
		int[] inorder = { -4, -10, 3, -1, 7, 11, -8, 2 };
		int[] postorder = { -4, -1, 3, -10, 11, -8, 2, 7 };
		TreeNode tree = cons.buildTree(inorder, postorder);
		cons.inOrder(tree);
		System.out.println();
		cons.postOrder(tree);
	}
}