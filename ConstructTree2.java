class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class ConstructTree2 {
	int pOrder;
	int iOrder;
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
	public TreeNode build(int[]preorder,int []inorder,TreeNode start){
		if (pOrder>=preorder.length) {
			return null;
		}
		TreeNode node=new TreeNode(preorder[pOrder++]);
		//left tree
		if (inorder[iOrder]!=node.val) {
			node.left=build(preorder, inorder, node);
		}
		iOrder++;
		
		if((start==null)||(inorder[iOrder]!=start.val)){
			node.right=build(preorder, inorder, start);
		}
		
		return node;
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pOrder=0;
        iOrder=0;
        if (preorder.length<=0) {
			return null;
		}
        return build(preorder, inorder, null);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructTree2 ct2=new ConstructTree2();
		int[] preorder = { 5, 3, 2, 1,6,7 };
		int[] inorder = {2,3,1,5,7,6 };
		TreeNode root=ct2.buildTree(preorder, inorder);
		ct2.preOrder(root);
		System.out.println();
		ct2.inOrder(root);
	}

}
