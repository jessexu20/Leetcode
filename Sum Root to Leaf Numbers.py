# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def traverse(root,num,ans):
    if root==None:
        return
    num=num+str(root.val)
    if root.left==None and root.right==None:
        ans.append(int(num))
    traverse(root.left,num,ans)
    traverse(root.right,num,ans)
    
class Solution:
    # @param root, a tree node
    # @return an integer
    def sumNumbers(self, root):
        ans=[]
        num=""
        traverse(root,num,ans)
        return sum(ans)
        
        
        
t1=TreeNode(1)
t2=TreeNode(2)
t3=TreeNode(3)
t4=TreeNode(4)
t5=TreeNode(5)
t6=TreeNode(6)
t1.left=t2
t1.right=t3
t2.left=t4
t3.left=t5
t5.left=t6        
s=Solution()
print s.sumNumbers(t1)
