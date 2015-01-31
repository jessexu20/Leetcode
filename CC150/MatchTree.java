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
public class MatchTree{//4.8
	public String preOrder(TreeNode root){
		String str="";
		if(root==null){
			str+="#";
			return str;
		}
		str+=root.val;
		str+=preOrder(root.left);
		str+=preOrder(root.right);
		return str;
	}
	public String inOrder(TreeNode root){
		String str="";
		if(root==null){
			str+="#";
			return str;
		}
		str+=inOrder(root.left);
		str+=root.val;
		str+=inOrder(root.right);
		return str;
	}
	public boolean matchTree1(TreeNode t1,TreeNode t2){
		String inOrder1=inOrder(t1);
		String inOrder2=inOrder(t2);
		String preOrder1=preOrder(t1);
		String preOrder2=preOrder(t2);
		if(inOrder1.indexOf(inOrder2)!=-1 && preOrder1.indexOf(preOrder2)!=-1)
			return true;
		else return false;
	}
	public boolean compare(TreeNode t1,TreeNode t2){
		if(t1==null && t2==null)
			return true;
		if(t1==null || t2==null)
			return false;
		if(t1.val!=t2.val)
			return false;
		return (compare(t1.left,t2.left)&&compare(t1.right,t2.right));
	}
	public boolean subTree(TreeNode t1,TreeNode t2){
		if(t1==null)
			return false;
		if(t1.val==t2.val)
			return compare(t1,t2);
		return subTree(t1.left,t2)||subTree(t1.right,t2);
		
	}
	public boolean matchTree2(TreeNode t1,TreeNode t2){
		if(t2==null)
			return true;
		if(t1==null)
			return false;
		return subTree(t1,t2);
	}
	public static void main(String args[]){
		MatchTree mt=new MatchTree();
		TreeNode root=new TreeNode(0);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		TreeNode i3=new TreeNode(3);
		TreeNode i6=new TreeNode(6);
		TreeNode i7=new TreeNode(7);
		root.left=t1;root.right=t2;
		t1.left=t3;t1.right=t4;t4.right=t5;
		t3.left=t6;t3.right=t7;
		i3.left=i6;i3.right=i7;
		System.out.println(mt.matchTree1(root,i3));
	
	}
	
}