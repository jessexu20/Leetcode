import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class RightView {
    public void level(TreeNode r, List<List<Integer>> res,int lev){
    	if(r==null)
			return;
		List<Integer> temp =new ArrayList<Integer>();
		if(res.size()<=lev){
			temp.add(r.val);
			res.add(temp);
		}
		else{
			res.get(lev).add(r.val);
		}
		level(r.left,res,lev+1);
		level(r.right,res,lev+1);
    }
	public List<List<Integer>> levelTraversal(TreeNode root){
		List<List<Integer>> result=new ArrayList();
		if(root==null)
			return result;
		level(root,result,0);
		return result;
	}
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
		if(root==null)
			return list;
		List<List<Integer>>levelResult=levelTraversal(root);
		for(List<Integer> l:levelResult){
			list.add(l.get(l.size()-1));
		}
		return list;
    }
	public static void main(String args[]){
		RightView rv=new RightView();
		TreeNode r=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		// TreeNode t2=new TreeNode(2);
		// TreeNode t3=new TreeNode(3);
		r.left=t2;
		r.right
		t2.right=t5;
		t3.right=t4;
		List<Integer> result= rv.rightSideView(r);
		for (int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}
}