/*
Verify Preorder Sequence in Binary Search Tree My Submissions Question
Total Accepted: 3267 Total Submissions: 9503 Difficulty: Medium
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?

*/

public class VerifyPreorder {
	//O(1) Space
	public boolean verifyPreorder(int[] preorder) {
	    int low = Integer.MIN_VALUE, i = -1;
	    for (int p : preorder) {
	        if (p < low)
	            return false;
	        while (i >= 0 && p > preorder[i])
	            low = preorder[i--];
	        preorder[++i] = p;
	    }
	    return true;
	}
    public boolean verifyPreorder(int[] preorder) {
        Stack <Integer> stack = new Stack();
        int low =Integer.MIN_VALUE;
        for(int i : preorder){
            if(i<low) return false;
            while(!stack.isEmpty() && i>stack.peek()){
                low=stack.pop(); 
            }
            stack.push(i);
        }
        return true;
    }
}