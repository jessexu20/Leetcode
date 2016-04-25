/*
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int v){
		val = v;
	}
}
public class UnivalSubtree {
    int cnt = 0; 
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return cnt;
    }
    public boolean helper(TreeNode root){
        if(root==null) return true;
        boolean l = helper(root.left);
        boolean r = helper(root.right);
        if((l && r) ==false) return false;// either of the child doesn't sastify then root is not satisfy
        if((root.left!=null && root.left.val!=root.val) || (root.right!=null && root.right.val!=root.val))//check for child values
            return false;
        cnt++;
        return true;
        
    }
}