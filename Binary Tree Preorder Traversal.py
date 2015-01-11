# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def preorder(root,ans):
    if root==None:
        return
    ans.append(root.val)
    preorder(root.left,ans)
    preorder(root.right,ans)
class Solution:
    # @param root, a tree node
    # @return a list of integers
    def preorderTraversal(self, root):
        ans=[]
        preorder(root,ans)
        return ans
        
        
t1=TreeNode(1)
t2=TreeNode(2)
t3=TreeNode(3)
t4=TreeNode(4)
t5=TreeNode(5)
t6=TreeNode(6)
t1.left=t2
t2.left=t3
t2.right=t4  
t1.right=t5
t5.right=t6       
s=Solution()
print s.preorderTraversal(t1)
