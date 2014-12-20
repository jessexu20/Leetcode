class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class FlattenTree{
    public void flatten(TreeNode root) {
		if(root==null)
			return;
		if(root.left!=null || root.right!=null){
			if(root.left!=null)
				flatten(root.left);
			if(root.right!=null)
				flatten(root.right);
		}
		else return;
		TreeNode right=root.right;
		TreeNode left=root.left;
		if(left!=null){
			root.right=root.left;
			root.left=null;
			TreeNode current=root;
			while(current.right!=null)
				current=current.right;
			current.right=right;
		}
    }
	public static void main(String args[]){
		FlattenTree ft= new FlattenTree();
		TreeNode root=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		root.left=t2;t2.left=t3;
		// root.left=t2;root.right=t5;
		// t2.left=t3;t3.left=t4;
		// t5.right=t6;
 		ft.flatten(root);
		while(root!=null){
			System.out.println(root.val);
			root=root.right;
		}
			
	}
}