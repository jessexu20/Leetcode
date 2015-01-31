class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		val=x;
		left=null;
		right=null;
	}
}
public class FindCommonParent{
	public boolean cover(TreeNode root,TreeNode x){
		if(root==null)
			return false;
		if(root==x)
			return true;
		else return cover(root.left,x)||cover(root.right,x);
	}
	public TreeNode findParent(TreeNode root,TreeNode a,TreeNode b){//4.7
		if(a==root||b==root)
			return root;
		boolean is_a_left=cover(root.left,a);
		boolean is_b_left=cover(root.left,b);
		if(is_a_left&&is_b_left)
			return findParent(root.left,a,b);
		else if(!is_a_left&&!is_b_left)
			return findParent(root.right,a,b);
		else return root;
	}
	public static void main(String args[]){
		FindCommonParent fcp=new FindCommonParent();
		TreeNode root=new TreeNode(0);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		root.left=t1;root.right=t2;
		t1.left=t3;t1.right=t4;t4.right=t5;
		t3.left=t6;t3.right=t7;
		System.out.println(fcp.findParent(root,t6,t2).val);
	
	}
	
}