# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def searchPath(root,value,ans):
    if root==None:
        return
    root.val=root.val+value
    if root.left==None and root.right==None:
        ans.append(root.val)        
    searchPath(root.left,root.val,ans)
    searchPath(root.right,root.val,ans)

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a boolean
    def hasPathSum(self, root, sum):
        ans=[]
        searchPath(root,0,ans)
        for i in ans:
            if i==sum:
                return True
            else:
                continue
        return False


t1=TreeNode(5)
t2=TreeNode(4)
t3=TreeNode(8)
t4=TreeNode(11)
t5=TreeNode(13)
t6=TreeNode(4)
t7=TreeNode(7)
t8=TreeNode(2)
t9=TreeNode(1)
t1.left=t2
t2.left=t4
t4.left=t7
t4.right=t8
t1.right=t3
t3.left=t5
t3.right=t6
t6.right=t9

s=Solution()
print s.hasPathSum(t1,22)