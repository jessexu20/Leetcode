import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
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
public class LevelTraverse{//4.4
	public void level(TreeNode root,List<List<Integer>> result,int level){
		if(root!=null){
			if(result.size()<=level){
				List<Integer> t=new ArrayList();
				t.add(root.val);
				result.add(t);
			}
			else
				result.get(level).add(root.val);
				
		}
		else return;
		level(root.left,result,level+1);
		level(root.right,result,level+1);
		
	}
	public List<List<Integer>> levelTraversal(TreeNode root){
		if(root==null)
			return null;
		List<List<Integer>> result=new ArrayList();
		level(root,result,0);
		return result;
	}
	public static void main(String args[]){
		LevelTraverse lt=new LevelTraverse();
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
		System.out.println(lt.levelTraversal(root));
	}
}