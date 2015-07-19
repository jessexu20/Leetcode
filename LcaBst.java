class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class LcaBst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
			return null;
		if (p==q)
			return p;
		if(root==p || root==q)
			return root;
		else if(p.val<root.val && root.val<q.val || p.val>root.val && root.val>q.val){
			return root;
		}
		else if(p.val<root.val && q.val<root.val){
			return lowestCommonAncestor(root.left,p,q);
		}
		else return lowestCommonAncestor(root.right,p,q);
    }
	public static void main(String args[]){
		LcaBst lca =new LcaBst();
		TreeNode root=new TreeNode(4);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		root.left=t2;root.right=t5;
		t2.left=t1;t2.right=t3;root.right=t5;
		t5.left=t6;
		System.out.println(lca.lowestCommonAncestor(root,t2,t6).val);
	}
}