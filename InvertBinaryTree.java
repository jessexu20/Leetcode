class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<TreeNode>();
		if(root==null)
			return null;
		que.add(root);
		while(!que.isEmpty()){
			TreeNode temp=que.poll();
			if(temp.left!=null || temp.right!=null){
				TreeNode l=temp.left;
				TreeNode r=temp.right;
				temp.left=r;
				temp.right=l;
				if(l!=null)
					que.add(l);
				if(r!=null)
					que.add(r);
			}
		}
		return root;
    }
}