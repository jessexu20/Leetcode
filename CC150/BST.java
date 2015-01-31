import java.util.List;
import java.util.ArrayList;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode(int x){
		val=x;
		left=null;
		right=null;
		parent=null;
	}
}
public class BST{//4.6
	public void inOrder(TreeNode root,List<Integer> sequence){
		if(root==null)
			return;
		inOrder(root.left,sequence);
		sequence.add(root.val);
		inOrder(root.right,sequence);
	}
	public boolean checkBST(TreeNode node){//4.5
		List<Integer> sequence=new ArrayList();
		inOrder(node,sequence);
		for(int i=0;i<sequence.size()-1;i++){
			if(sequence.get(i)>=sequence.get(i+1))
				return false;
		}
		return true;
	}
	public TreeNode findNext(TreeNode node){//4.6
		if(node.right!=null){
			TreeNode temp=node.right;
			while(temp.left!=null){
				temp=temp.left;
			}
			return temp;
		}
		if(node.parent.val>node.val){
			return node.parent;
		}
		else{
			TreeNode temp=node.parent;
			while(temp!=null && temp.val<node.val){
				temp=temp.parent;
			}
			if(temp==null)
				return null;
			return temp;
		}
			
	}
	public static void main(String args[]){
		BST bst= new BST();
		TreeNode t0= new TreeNode(0);
		TreeNode t1= new TreeNode(1);
		TreeNode t2= new TreeNode(2);
		TreeNode t3= new TreeNode(3);
		TreeNode t4= new TreeNode(4);
		TreeNode t5= new TreeNode(5);
		t3.left=t1;t1.left=t0;t1.right=t2;
		t3.right=t5;t5.left=t4;
		t0.parent=t1;t2.parent=t1;t1.parent=t3;t4.parent=t5;t5.parent=t3;
		System.out.println(bst.checkBST(t3));
		System.out.println(bst.findNext(t4).val);
	}

}