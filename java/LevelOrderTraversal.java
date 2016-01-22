import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root==null) return result;
        Queue<TreeNode> que= new LinkedList();
        Queue<Integer> level= new LinkedList();
        que.offer(root);
        level.offer(0);
        while(!que.isEmpty()){
            TreeNode t= que.poll();
            int index=level.poll();
            if(t.left!=null){
                que.offer(t.left);
                level.offer(index+1);
            }
            if(t.right!=null){
                que.offer(t.right);
                level.offer(index+1);
            }
            if(index<result.size()){
                (result.get(index)).add(t.val);
            }
            else{
                List<Integer> list= new ArrayList();
                list.add(t.val);
                result.add(list);
            }
			System.out.println(t.val);
        }
        return result;
    }
	public static void main(String args[]) {
		LevelOrderTraversal lt = new LevelOrderTraversal();
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
		System.out.println(lt.levelOrder(root));
	}
}