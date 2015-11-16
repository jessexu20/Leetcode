/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
*/
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int v){
		val = v;
	}
}
public class InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null, conductor = root;
        
        while (conductor != null) {
            if (conductor.val > p.val) {
                successor = conductor;
                conductor = conductor.left;
            } else
                conductor = conductor.right;
        }
        
        return successor;
    }
}