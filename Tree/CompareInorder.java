class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	boolean visited;
	TreeNode(int v){
		val = v;
		visited = false;
	}
}
public class CompareInorder{
	public boolean compare(TreeNode r1, TreeNode r2){
		TreeNode n1 = getNext(r1);
		TreeNode n2 = getNext(r2);
		while(n1!=null && n2!=null){
			if(n1.val != n2.val)
				return false;
			n1.visited = true;
			n2.visited = true;
			n1 = getNext(n1);
			n2 = getNext(n2);
		}
		if(n1==null && n2 == null)
			return true;
		else return false;
	}
	public void inorderTraversal(TreeNode root){
		TreeNode n = getNext(root);
		while(n!=null){
			n.visited = true;
			System.out.println(n.val);
			n = getNext(n);
		}
	}
	public TreeNode getNext(TreeNode r){
		if(r==null)
			return null;
		if(r.left!=null && !r.left.visited)
			return getNext(r.left);
		if(!r.visited)
			return r;
		if(r.right!=null && !r.right.visited)
			return getNext(r.right);
		return getNext(r.parent);
	}
	public static void main(String args[]){
		CompareInorder ci = new CompareInorder();
		TreeNode root = new TreeNode(2);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(3);
		root.left = t1;
		root.right = t2;
		t1.parent = root;
		t2.parent = root;
		TreeNode r2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		r2.right = t3;
		t3.right = t4;
		t4.parent = t3;
		t3.parent = r2;
		// ci.inorderTraversal(r2);
		// System.out.println()
		System.out.println(ci.compare(root,r2));
		
	}
}