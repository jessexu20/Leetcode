class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class BSTIterator {
    Queue <Integer> order;
	public void inOrder(TreeNode root, Queue<Integer> res){
		if(root==null)
			return;
		inOrder(root.left,res);
		res.add(root.val);
		inOrder(root.right,res);
	}
    public BSTIterator(TreeNode root) {
        order=new LinkedList<Integer>();
		inOrder(root,order);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(order.size()>0)
			return true;
		else return false;
    }

    /** @return the next smallest number */
    public int next() {
		if(order.size()>0)
			return order.poll();
		else return 0;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */