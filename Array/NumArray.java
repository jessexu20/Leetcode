class TreeNode{
    int val;
    int start;
    int end;
    TreeNode left;
    TreeNode right;
    TreeNode(int v,int s, int e){
        val = v;
        start = s;
        end = e;
    }
}
public class NumArray {
    TreeNode root; 
    int [] cache;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
        cache = nums.clone();
    }
    private TreeNode buildTree(int [] nums, int start, int end){
        if(start == end){
            return new TreeNode(nums[start],start,start);
        }
        int mid = start + (end - start)/2;
        TreeNode left = buildTree(nums, start, mid);
        TreeNode right = buildTree(nums, mid+1, end);
        int sum = left.val + right.val;
        TreeNode node = new TreeNode(sum,left.start, right.end);
        node.left = left;
        node.right = right;
        return node;
    }
    void update(int i, int val) {
        update(root, i, val);
        cache[i] = val;
    }
    void update(TreeNode node, int i, int val){
        if(node == null || i > node.end || i < node.start)
            return;
        node.val +=(val - cache[i]);
        update(node.left, i, val);
        update(node.right, i, val);
    }
    public int sumRange(int i, int j) {
        return sumHelper(root, i, j);
    }
    public int sumHelper(TreeNode node, int i, int j){
        if(node.end < i || node.start > j)
            return 0;
        if(node.start == i && node.end == j)
            return node.val;
		if(node.left!=null && j <= node.left.end){
			return sumHelper(node.left, i, j);
		}
		else if(node.right!=null && i >= node.right.start)
			return sumHelper(node.right,i, j);
		else{
	        int left = sumHelper(node.left, i, node.left.end);
	        int right = sumHelper(node.right, node.left.end+1, j);
	        return left + right;
		}
    }
	public void preorder(){
		preorder(root);
	}
	public void preorder(TreeNode root){
		if(root == null)
			return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	public static void main(String args[]){
		int [] nums = {1,2,3,4,5,6,7};
		NumArray numArray = new NumArray(nums);
		numArray.preorder();
		System.out.println(numArray.sumRange(0, 1));
		numArray.update(1, 10);
		System.out.println(numArray.sumRange(1, 2));
		
	}
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);