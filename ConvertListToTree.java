class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; next = null; }
   }
public class ConvertListToTree{
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
	public TreeNode convert(ListNode head, int start,int end){
		if(end-start==0)
			return null;
		ListNode current=head;
		int mid=start+(end-start)/2;
		for(int i=0;i<mid;i++){
			if(current==null) return null;
			current=current.next;
		}
		if(current==null) return null;
		TreeNode root=new TreeNode(current.val);
		root.left=convert(head,start,mid);
		root.right=convert(head,mid+1,end);
		return root;
	}
	
    public TreeNode sortedListToBST(ListNode head) {
        int length=0;
		ListNode current=head;
		while(current!=null){
			length++;
			current=current.next;
		}
		return convert(head,0,length);
    }
	public static void main (String args[]){
		ConvertListToTree clt=new ConvertListToTree();
		ListNode l0=new ListNode(0);
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		
		l0.next=l1;l1.next=l2;l2.next=l3;l3.next=l4;
		l4.next=l5;
		TreeNode root=clt.sortedListToBST(l0);
		System.out.println("pre");
		clt.pretraverse(root);
		System.out.println("mid");
		clt.midtraverse(root);
		
		
	}
}