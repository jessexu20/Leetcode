import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class CountTreeNode {
    public int countNodes(TreeNode root) {
    	if (root==null)
			return 0;
		int hl=0,hr=0;
		TreeNode l=root; TreeNode r=root;
		while(l!=null){
			hl++;
			l=l.left;
		}
		while(r!=null){
			hr++;
			r=r.right;
		}
		if(hl==hr) 
			return (int)Math.pow(2,hl)-1;
		return 1+countNodes(root.left)+countNodes(root.right);
    }
	public static void main(String args[]){
		CountTreeNode ctn=new CountTreeNode();
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		TreeNode t8=new TreeNode(8);
		t1.left=t2;t1.right=t3;
		t2.left=t4;t2.right=t5;t3.left=t6;t3.right=t7;
		t4.left=t8;
		System.out.println(ctn.countNodes(t1));
	}
}