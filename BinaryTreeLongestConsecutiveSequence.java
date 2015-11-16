/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class BinaryTreeLongestConsecutiveSequence {
    int max =0;
    public int longestConsecutive(TreeNode root) {
        helper(root,0);
        return max;
    }
    public void helper(TreeNode root,int count){
        if(root == null) return;
		max=Math.max(max,++count);
		if(root.left==null && root.right==null) return;
		if(root.right!=null){
			if(root.right.val==root.val+1) helper(root.right,count);
			else helper(root.right,0);
		} 
		if(root.left!=null){
			if(root.left.val==root.val+1) helper(root.left,count);
			else helper(root.left,0);
		} 
	}
}