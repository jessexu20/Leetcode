import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class FindSequenceTree {
	int max =0;
	String longest = "";
	public List<Integer> findSeq(TreeNode root){
		helper(root,"");
		List<Integer> ret= new ArrayList<Integer>();
		for(int i =0 ; i < longest.length();i++){
			ret.add(longest.charAt(i)-'0');
		}		
		return ret;
	}
	public void helper(TreeNode root,String str){
		String result = str+String.valueOf(root.val);
		if(result.length()>max){
			max=result.length();
			longest=result;
		}
		if(root.left==null && root.right==null) return;
		if(root.right!=null){
			if(root.right.val==root.val+1) helper(root.right,result);
			helper(root.right,"");
		} 
		if(root.left!=null){
			if(root.left.val==root.val+1) helper(root.left,result);
			helper(root.left,"");
		} 
	}
	public static void main(String args[]) {
		FindSequenceTree cmt = new FindSequenceTree();
		TreeNode root=new TreeNode(4);
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		TreeNode t8=new TreeNode(8);
		root.left=t1;
		t1.left=t2;
		t1.right=t3;
		root.right=t6;
		t6.right=t7;
		t7.left=t8;
		System.out.println(cmt.findSeq(root));
	}
}