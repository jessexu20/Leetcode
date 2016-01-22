package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTree {
	TreeNode r;

	AVLTree() {
		r = null;
	}

	public void delete(int num) {
		r = delete(r, num);
	}

	private TreeNode checkBalance(TreeNode root) {
		// check balance function
		int diff = subTreeHeight(root.left) - subTreeHeight(root.right);
		if (diff == 2) {
			if (subTreeHeight(root.left.left) >= subTreeHeight(root.left.right))
				root = rightRotate(root);
			else
				root = leftRightRotate(root);
		} else if (diff == -2) {
			if (subTreeHeight(root.right.left) <= subTreeHeight(root.right.right))
				// only when subsub left tree is longer than subsub right, do
				// right left
				root = leftRotate(root);
			else
				root = rightLeftRotate(root);
		}
		return root;
	}

	private TreeNode delete(TreeNode root, int num) {
		if (root == null) {
			return null;
		}
		if (root.val == num) {
			if (root.left == null && root.right == null)
				root = null;
			else if (root.left == null || root.right == null) {
				root = (root.left == null) ? root.right : root.left;
			} else {
				// put the leftmost node in the right subtree to replace the
				// node
				TreeNode temp = root.right;
				while (temp.left != null) {
					temp = temp.left;
				}
				root.val = temp.val;
				if (temp.right != null) {
					temp.val = temp.right.val;
					temp.left = temp.right.left;
					temp.right = temp.right.right;
				} else
					temp = null;
			}

		} else if (num > root.val) {
			root.right = delete(root.right, num);// delete node in right tree
			root = checkBalance(root);
		} else {
			root.left = delete(root.left, num);// delete node in left tree
			root = checkBalance(root);
		}
		return root;
	}

	public void insert(int num) {
		r = insert(r, num);
	}

	private TreeNode insert(TreeNode root, int num) {
		if (root == null) {
			root = new TreeNode(num);
			return root;
		}
		if (num > root.val) {
			root.right = insert(root.right, num);
			root = checkBalance(root);
		} else {
			root.left = insert(root.left, num);
			root = checkBalance(root);
		}
		return root;

	}

	private int subTreeHeight(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math
				.max(subTreeHeight(root.left), subTreeHeight(root.right));
	}

	private TreeNode leftRotate(TreeNode root) {
		TreeNode temp = root.right;
		root.right = temp.left;
		temp.left = root;
		return temp;
	}

	private TreeNode rightRotate(TreeNode root) {
		TreeNode temp = root.left;
		root.left = temp.right;
		temp.right = root;
		return temp;
	}

	private TreeNode leftRightRotate(TreeNode root) {
		root.left = leftRotate(root.left);
		return rightRotate(root);
	}

	private TreeNode rightLeftRotate(TreeNode root) {
		root.right = rightRotate(root.right);
		return leftRotate(root);
	}

	private List<List<Integer>> levelOrder() {
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

	public static void main(String args[]) {
		AVLTree avlTree = new AVLTree();
		avlTree.insert(1);
		avlTree.insert(2);
		avlTree.insert(3);
		avlTree.insert(4);
		avlTree.insert(5);
		avlTree.insert(7);
		// System.out.println(avlTree.levelOrder());
		avlTree.insert(6);
		avlTree.insert(8);
		avlTree.insert(9);
		System.out.println(avlTree.levelOrder());
		avlTree.delete(5);
		System.out.println(avlTree.levelOrder());
		avlTree.delete(9);
		System.out.println(avlTree.levelOrder());
	}
}