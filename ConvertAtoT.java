class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class ConvertAtoT{
	public void pretraverse(TreeNode root){
		if(root==null)
			return;
		System.out.println(root.val);
		pretraverse(root.left);
		pretraverse(root.right);
	}
	public void midtraverse(TreeNode root){
		if(root==null)
			return;
		midtraverse(root.left);
		System.out.println(root.val);
		midtraverse(root.right);
	}
    public TreeNode convert(int[] num,int start,int end) {
		if(start==end) 
			return null;
		int mid=(start+end)/2;
    	TreeNode root = new TreeNode(num[mid]);
		root.left=convert(num,start,mid);
		root.right=convert(num,mid+1,end);
		return root;
    }
    public TreeNode sortedArrayToBST(int[] num) {
    	return convert(num,0,num.length);
    }
	public static void main(String args[]){
		ConvertAtoT cat=new ConvertAtoT();
		int num[]={1};
		TreeNode root=cat.sortedArrayToBST(num);
		System.out.println("pre traverse");
		cat.pretraverse(root);
		System.out.println("mid traverse");
		cat.midtraverse(root);
	}
}