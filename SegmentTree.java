class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int v){
		val = v;
	}
}
public class SegmentTree{
	public void preorder(TreeNode root){
		if(root==null)
			return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	public TreeNode constructMinTree(int [] nums){
		return build(nums,0,nums.length-1);
	}
	public TreeNode build(int [] nums, int start, int end){
		if(start == end)
			return new TreeNode(nums[start]);
		int mid = start + (end-start)/2;
		TreeNode left = build(nums,start,mid);
		TreeNode right = build(nums,mid+1,end);
		int min = Math.min(left.val,right.val);
		// int min = left.val+right.val;
		TreeNode root = new TreeNode(min);
		root.left = left;
		root.right = right;
		return root;
	}
	public static void main(String args[]){
		SegmentTree tree = new SegmentTree();
		int [] nums = {2,5,1,4,9,3};
		TreeNode root = tree.constructMinTree(nums);
		tree.preorder(root);
	}
}