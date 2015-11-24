import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	int start;
	int end;
	TreeNode(int v){
		val = v;
	}
}
public class SegmentTree{
	public int query(TreeNode root, int start, int end){
		if(root == null) return 0;
		if(root.start > end) return 0;
		if(root.end < start) return 0;
		if(root.start>start && root.end < end ) return root.val;
		return query(root.left,start,end)+query(root.right,start,end);
	
	}
	public TreeNode constructMinTree(int [] nums){
		return build(nums,0,nums.length-1);
	}
	public TreeNode build(int [] nums, int start, int end){
		if(start == end){
			TreeNode t = new TreeNode(nums[start]);
			t.start = start;
			t.end = end;
			return t;
		}
		int mid = start + (end-start)/2;
		TreeNode left = build(nums,start,mid);
		TreeNode right = build(nums,mid+1,end);
		// int min = Math.min(left.val,right.val);
		int min = left.val+right.val;
		TreeNode root = new TreeNode(min);
		root.start = start;
		root.end = end;
		root.left = left;
		root.right = right;
		return root;
	}
	private List<List<Integer>> levelOrder(TreeNode r) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		if (r != null) {
			que.offer(r);
		}
		while (!que.isEmpty()) {
			int len = que.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < len; i++) {
				TreeNode temp = que.poll();
				list.add(temp.val);
				if (temp.left != null)
					que.offer(temp.left);
				if (temp.right != null)
					que.offer(temp.right);
			}
			result.add(list);
		}
		return result;
	}
	public void preorder(TreeNode root){
		if(root==null)
			return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	public static void main(String args[]){
		SegmentTree tree = new SegmentTree();
		int [] nums = {1,3,5,7,9,11};
		TreeNode root = tree.constructMinTree(nums);
		tree.preorder(root);
		System.out.println(tree.levelOrder(root));
		System.out.println(tree.query(root,1,3));
	}
}