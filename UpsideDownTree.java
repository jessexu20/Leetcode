/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  

*/	
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class UpsideDownTree {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) return null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack();
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        TreeNode newRoot= stack.peek();//new root is the leftmost child
        while(!stack.isEmpty()){
            cur= stack.pop();//stack.peek()is the parent of the left most child
            cur.right = stack.isEmpty()? null:stack.peek();// have parent=> make parent right tree
            cur.left = stack.isEmpty()? null:stack.peek().right;// have parent=> make parent's right child to sel.left child
        }
        return newRoot;
    }
}