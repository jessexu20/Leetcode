class TreeNode {
     int val;
     TreeNode left;
	 TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class ConstructTree{
	public int find(int [] array, int content){
		for(int i =0; i<array.length; i++){
			if(array[i]==content){
				return i;
			}
		}
		return -1;
	}
	public TreeNode build(int[] inorder, int[] postorder,int from,int to) {
		if(from==to){
			return new TreeNode(inorder[from]);
		} 
		int root = postorder[to-1];
		TreeNode t1= new TreeNode(root);
		int index= find(inorder,root);
		t1.left=build(inorder,postorder,0,index-1);
		t1.right=build(inorder,postorder,index+1,to-1);
	
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int len=postorder.length;
		int root = postorder[len-1];
		TreeNode t1= new TreeNode(root);
		int index= find(inorder,root);
		t1.left=build(inorder,postorder,0,index-1);
		t1.right=build(inorder,postorder,index+1,len-1);
		return t1;
	}
	public static void main(String args[]){
		ConstructTree cons=new ConstructTree();
		int [] inorder={4,2,6,1,3,5};
		int [] postorder={4,6,2,5,3,1};
		cons.buildTree(inorder,postorder);
	}
}