class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class LcaTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
			return null;
		if(root==p || root==q)
			return root;
		TreeNode left=lowestCommonAncestor(root.left,p,q);
		TreeNode right=lowestCommonAncestor(root.right,p,q);
		if(left!=null && right!=null){
			return root;
		}
		return left!=null?left:right;
    }
	public static void main(String args[]){
		LcaTree lca =new LcaTree();
		TreeNode root=new TreeNode(4);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		root.left=t1;root.right=t5;
		t1.left=t2;t2.right=t3;root.right=t5;
		t5.left=t6;t5.right=t7;
		System.out.println(lca.lowestCommonAncestor(root,t2,t6).val);
	}
}