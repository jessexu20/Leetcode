# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def postorder(root,ans):
    if root==None:
        return
    if root.left!=None:
        # ans.append(root.left.val)
        postorder(root.left,ans)
    if root.right!=None:
        # ans.append(root.right.val)
        postorder(root.right,ans)
    ans.append(root.val)
        
class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        ans=[]
        postorder(root,ans)
        return ans
        
t1=TreeNode(1)
t2=TreeNode(2)
t3=TreeNode(3)
t4=TreeNode(4)
t1.left=t2
t1.right=t3
t2.left=t4        
s=Solution()
print s.postorderTraversal(t1)

        
