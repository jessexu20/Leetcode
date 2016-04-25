import java.util.*;
class TreeNode{
	int val;
	List<TreeNode> children;
	TreeNode(int x){
		this.val = x;
		this.children = new ArrayList<TreeNode>();
	}
}
public class LongestConsecutiveSequence{
	int max = 0;
	public int findArr(int [] nums){
		if(nums.length<1) return 0;
		int temp = nums[0];
		int length = 1;
		int max = 0;
		for(int i = 1;i<nums.length;i++){
			if(nums[i]== temp+1)
				length++;
			else
				length = 1;
			max = Math.max(max,length);
			temp = nums[i];
		}
		return max;
	}
	public int findTree(TreeNode root){
		helper(root,1);
		return max;
	}
	public void helper(TreeNode root,int length){
		max = Math.max(max,length);
		if(root == null) return;
		List<TreeNode> list = new ArrayList(root.children);
		for(TreeNode t: list){
			if(t.val==root.val+1)
				helper(t,length+1);
			else helper(t,1);
		}
	}
	public static void main(String args[]){
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int [] nums =  {6,1,2,3,4,5};
		TreeNode root = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		root.children.add(t2);root.children.add(t4);root.children.add(t5);
		t4.children.add(t7);
		t2.children.add(t3);t3.children.add(t6);
		System.out.println(lcs.findArr(nums));
		System.out.println(lcs.findTree(root));
	}
}