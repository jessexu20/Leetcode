import java.util.*;

class TreeNode4 {
	int val;
	TreeNode4[] children;

	TreeNode4(int x) {
		this.val = x;
		children = new TreeNode4[4];
	}
}

public class CompressImage {
	public TreeNode4 compress(int[][] image) {
		int row = image.length;
		int col = image[0].length;
		TreeNode4 root = new TreeNode4(0);
		construct(root, image, 0, row - 1, 0, col - 1);
		return root;
	}

	public void construct(TreeNode4 node, int[][] image, int x_start,
			int x_end, int y_start, int y_end) {
		if (x_start == x_end)
			return;
		int x_mid = x_start + (x_end - x_start) / 2;
		int y_mid = y_start + (y_end - y_start) / 2;

		helper(node, image, 0, x_start, x_mid, y_start, y_mid);// top left
		helper(node, image, 1, x_start, x_mid, y_mid + 1, y_end);// top right
		helper(node, image, 2, x_mid + 1, x_end, y_start, y_mid);// bottom left
		helper(node, image, 3, x_mid + 1, x_end, y_mid + 1, y_end);// bottom
																	// right
	}

	public void helper(TreeNode4 node, int[][] image, int index, int x_start,
			int x_end, int y_start, int y_end) {
		if (black(image, x_start, x_end, y_start, y_end)) {
			node.children[index] = new TreeNode4(1);
		} else {
			TreeNode4 t = new TreeNode4(0);
			node.children[index] = t;
			construct(t, image, x_start, x_end, y_start, y_end);
		}
	}

	public boolean black(int[][] image, int x_start, int x_end, int y_start,
			int y_end) {
		if (x_start == x_end)
			return image[x_start][y_start] == 1 ? true : false;
		for (int i = x_start; i < x_end; i++) {
			for (int j = y_start; j < y_end; j++) {
				if (image[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public List<List<Integer>> levelOrder(TreeNode4 root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode4> que = new LinkedList<TreeNode4>();
		que.offer(root);
		while (!que.isEmpty()) {
			int size = que.size();
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode4 cur = que.poll();
				for (int j = 0; j < 4; j++) {
					if (cur.children[j] != null)
						que.offer(cur.children[j]);
				}
				temp.add(cur.val);
			}
			list.add(temp);
		}
		return list;
	}
	public void mergeTree(TreeNode4 root1, TreeNode4 root2){
		if(root1==null || root2==null) return;
		if(root1.val == 0 || root2.val == 0) root1.val = 0;
		for(int i = 0; i < 4; i++){
			if(root1.children[i]==null && root2.children[i]!=null)
				root1.children[i]=root2.children[i];
			mergeTree(root1.children[i],root2.children[i]);
		}
	}

	public static void main(String args[]) {
		CompressImage compress = new CompressImage();
		int[][] image1 = { { 0, 0, 1, 1 ,1 }, { 1, 0, 1, 1,1 }, { 0, 0, 0, 0,1 },
				{ 1, 1, 1, 0,1 },{1,1,1,1,1} };
		int[][] image2 = { { 0, 0, 0, 0 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 },
				{ 0, 0, 0, 0 } };
		TreeNode4 root1 = compress.compress(image1);
		// TreeNode4 root2 = compress.compress(image2);
		System.out.println(compress.levelOrder(root1));
		// System.out.println(compress.levelOrder(root2));
		// compress.mergeTree(root1,root2);
		// System.out.println(compress.levelOrder(root1));
		
	}
}
