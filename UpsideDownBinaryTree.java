/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class UpsideDownBinaryTree {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) return null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack();
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        System.out.println(cur.val);
        TreeNode newRoot= stack.peek();
        while(!stack.isEmpty()){
			cur=stack.pop();
			cur.right= !stack.isEmpty()?stack.peek():null;
			cur.left= !stack.isEmpty()?stakc.peek().right:null;
        }
        return newRoot;
    }
}