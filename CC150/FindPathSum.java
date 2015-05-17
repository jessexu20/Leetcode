import java.util.List;
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
public class FindPathSum{//4.9
	public void findPath(TreeNode root,int value,List<List<Integer>> list,List<Integer> path,int depth){
		if(root==null)
			return;
		path.add(root.val);
		int temp=0;
		for(int i=depth;i>=0;i--){
			temp+=path.get(i);
			if(temp==value){
				list.add(path.subList(i,depth+1));
			}
		}
		findPath(root.left,value,list,new ArrayList(path),depth+1);
		findPath(root.right,value,list,new ArrayList(path),depth+1);
	}
	
	public List<List<Integer>> findSum(TreeNode root,int value){
		List<List<Integer>> list=new ArrayList();
		List<Integer>t=new ArrayList();
		findPath(root,value,list,t,0);
		return list;
	}
	public static void main(String args[]){
		FindPathSum fps=new FindPathSum();
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
		System.out.println(fps.findSum(root,10));
	}
}