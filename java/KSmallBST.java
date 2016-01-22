import java.util.List;
import java.util.ArrayList;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class KSmallBST {
	public void midOrder(List<Integer>list,TreeNode root){
		if(root==null)
			return;
		midOrder(list,root.left);
		list.add(root.val);
		midOrder(list,root.right);
	}
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res=new ArrayList<Integer>();
		midOrder(res,root);
		System.out.println(res);
		if(k>res.size())
			return 0;
		else return res.get(k-1);
    }
	public static void main(String args[]){
		KSmallBST ksb=new KSmallBST();
		TreeNode root=new TreeNode(4);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		// root.left=t2;
		// t2.left=t1;t2.right=t3;
		// root.right=t6;t6.right=t7;
		System.out.println(ksb.kthSmallest(root,1));
	}
}