package google;

public class BinaryTreeToDoubleLinkedList {
	public DoubleListNode inOrder(TreeNode root) {
		if (root == null)
			return null;
		DoubleListNode left = inOrder(root.left);
		DoubleListNode right = inOrder(root.right);
		DoubleListNode t = new DoubleListNode(root.val);
		if (left != null) {
			DoubleListNode cur = left;
			while (cur.next != null)
				cur = cur.next;
			cur.next = t;
			t.prev = cur;
			t.next = right;
			return left;
		} else {
			t.next = right;
			if (right!=null) {
				right.prev = t;
			}
			return t;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeToDoubleLinkedList test = new BinaryTreeToDoubleLinkedList();
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		root.left = node1;
		node1.left = node3;
		node1.right = node4;
		root.right = node2;
		DoubleListNode result = test.inOrder(root); 
		DoubleListNode cur = result;
		while (cur!=null) {
			System.out.println(cur.val);
			cur= cur.next;
		}
	}

}
