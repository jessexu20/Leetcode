package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
    public int bfs(TreeNode root) {
    	int count=0;
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	if (root!=null) {
			count++;
			queue.offer(root);
		}
    	while (queue.peek()!=null){
    		TreeNode temp;
    		temp=queue.poll();
    		System.out.println(temp.val);
    		if (temp.left!=null) {
				queue.offer(temp.left);
			}
    		if (temp.right!=null) {
				queue.offer(temp.right);
			}
    	}
		return 0;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		BFS mDepth=new BFS();
		System.out.println(mDepth.bfs(t1));
		
	}

}
