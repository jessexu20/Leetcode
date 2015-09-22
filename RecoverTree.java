import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class RecoverTree {
    public void recoverTree(TreeNode root) {
		TreeNode cur= root;
		TreeNode first=null,second=null,temp=null,lastPrint=null;
		while(cur!=null){
			if(cur.left==null){
				//to check if the midorder traverse follow the sequence
				if(lastPrint!=null&& cur.val<lastPrint.val){
					if(first==null){first = lastPrint;second = cur;}
					else{second = cur;}
				}
				lastPrint=cur;
				//end
				cur=cur.right;
			}
			else{
				temp=cur.left;
				while(temp.right!=null&& temp.right!=cur)
					temp=temp.right;
				if(temp.right!=null ){
					temp.right=null;
					//to check the midorder sequence
					if(lastPrint!=null&&cur.val<lastPrint.val){
						if(first==null){first = lastPrint;second = cur;}
						else{second = cur;}
					}
					lastPrint=cur;
					//end
					cur = cur.right;
				}else{
					temp.right=cur;
					cur=cur.left;
				}
			}
		}
		if(first!=null & second!=null){
		    int t=first.val;
		    first.val=second.val;
	    	second.val=t;
		}   
    }
	public void morrisTraverse(TreeNode root){
		TreeNode cur= root;
		TreeNode temp=null;
		while(cur!=null){
			if(cur.left==null){
				System.out.println(cur.val);
				cur=cur.right;
			}
			else{
				temp=cur.left;
				while(temp.right!=null&& temp.right!=cur)
					temp=temp.right;
				if(temp.right!=null ){
					temp.right=null;
					System.out.println(cur.val);
					cur = cur.right;
				}else{
					temp.right=cur;
					cur=cur.left;
				}
			}
		}
	}
	public static void main(String args[]){
		RecoverTree rt=new RecoverTree();
		TreeNode root=new TreeNode(4);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		TreeNode t0=new TreeNode(0);
		root.left=t1;
		t1.left=t2;
		t1.right=t3;
		root.right=t6;
		t6.right=t7;
		t3.left=t0;
		rt.morrisTraverse(root);
	}
}