/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

*/
/*
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Hint:

Consider implement these two helper functions:
getPredecessor(N), which returns the next smaller node to N.
getSuccessor(N), which returns the next larger node to N.
Try to assume that each node has a parent pointer, it makes the problem much easier.
Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
You would need two stacks to track the path in finding predecessor and successor node separately.

*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int v){
		val = v;
	}
}
public class ClostestBinaryTreeValue {
    Integer upper=null,lower=null;
    public int closestValue(TreeNode root, double target) {
        helper(root,target);
        if(upper==null && lower==null) return 0;
        if(upper==null) return lower;
        if(lower==null) return upper;
        return Math.abs(upper-target)>Math.abs(lower-target)?lower:upper;
           
    }
    public void helper(TreeNode root, double target){
        if(root==null) return;
        if(target>root.val){
            lower=root.val;
            helper(root.right,target);
        }
        else{
            upper=root.val;
            helper(root.left,target);
        }
    }
	//*** II
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> inOrder=new ArrayList<Integer>();
        List<Integer> result= new ArrayList<Integer>();
        inOrderT(inOrder,root);
        int i=0;
        for(i=0; i < inOrder.size();i++){
            if(inOrder.get(i)>target) break;
        }
        int length=0,left=i-1,right=i;
        while(length<k && left>=0 && right<inOrder.size()){
            if(Math.abs(inOrder.get(left)-target)<Math.abs(inOrder.get(right)-target)) result.add(inOrder.get(left--));
            else result.add(inOrder.get(right++));
            length++;
        }
        if(length<k){
            while(left<0 && length<k && right<inOrder.size()){
                result.add(inOrder.get(right++));
                length++;
            }
            while(right==inOrder.size() && length<k && left>=0){
                result.add(inOrder.get(left--));
                length++;
            }
        }
        return result;
    }
    public void inOrderT(List<Integer> result, TreeNode root){
        if(root==null) return;
        inOrderT(result,root.left);
        result.add(root.val);
        inOrderT(result,root.right);
    }
    
}