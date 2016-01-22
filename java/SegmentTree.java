import java.util.*;
class SegTreeNode {
	int val;
	SegTreeNode left;
	SegTreeNode right;
	int start;
	int end;

	SegTreeNode(int v) {
		val = v;
	}
}
public class SegmentTree{
	SegTreeNode root;
    public SegmentTree(int[] nums) {
        if(nums.length<1)
        return;
        root = build(nums,0,nums.length-1);
    }
    private SegTreeNode build(int[] nums, int start, int end) {
		if (start == end) {
			SegTreeNode t = new SegTreeNode(nums[start]);
			t.start = start;
			t.end = end;
			return t;
		}
		int mid = start + (end - start) / 2;
		SegTreeNode left = build(nums, start, mid);
		SegTreeNode right = build(nums, mid + 1, end);
		int sum = left.val + right.val;
		SegTreeNode root = new SegTreeNode(sum);
		root.start = start;
		root.end = end;
		root.left = left;
		root.right = right;
		return root;
	}
    public void update(int i, int val) {
        update(this.root,i,val);
    }
    private void update(SegTreeNode root, int index, int val) {
		if (root == null) {
			return;
		}
		if (root.start == index && root.end == index) {
			root.val = val;
			return;
		}
		if (root.left == null || root.right == null) {
			return;
		}
		if (root.left.start <= index && root.left.end >= index) {
			update(root.left, index, val);
		} else {
			update(root.right, index, val);
		}
		root.val = root.left.val + root.right.val;
	}
    public int sumRange(int i, int j) {
        return query(this.root,i,j);
    }
    private int query(SegTreeNode root, int start, int end) {
		if (root == null || root.start > end || root.end < start)
			return 0;
		if (root.start >= start && root.end <= end)
			return root.val;
		return query(root.left, start, end) + query(root.right, start, end);
	}
	private List<List<Integer>> levelOrder() {
		List<List<Integer>> result = new ArrayList<>();
		Queue<SegTreeNode> que = new LinkedList<>();
		if (this.root != null) {
			que.offer(this.root);
		}
		while (!que.isEmpty()) {
			int len = que.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < len; i++) {
				SegTreeNode temp = que.poll();
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
	public static void main(String args[]){
		int [] nums = {1,3,5,7,9,11};
		SegmentTree tree = new SegmentTree(nums);
		System.out.println(tree.levelOrder());
		System.out.println(tree.sumRange(1,3));
	}
}