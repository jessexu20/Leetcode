package leetcode;

import java.util.HashMap;

public class DFS {
	public void dfs(TreeNode root) {
		if (root==null) {
			return;
		}
		System.out.println(root.val);
//		HashMap<TreeNode, Integer> hashMap=new HashMap<TreeNode, Integer>();
//		hashMap.put(root, 1);
		dfs(root.left);
		dfs(root.right);
		
	}
	public static void main(String args[]) {
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		t1.left=t2;
		t1.right=t3;	
		t2.left=t4;
		t2.right=t5;
		DFS d=new DFS();
		d.dfs(t1);
	}
}
