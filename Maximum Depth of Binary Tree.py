# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def dfs(root,depth,maxDeep):
    if root==None:
        return
    depth=depth+1
    if root.left==None and root.right==None:
        # print depth
        maxDeep.append(depth)
    dfs(root.left,depth,maxDeep)
    dfs(root.right,depth,maxDeep)
        
class Solution:
    # @param root, a tree node
    # @return an integer
    def maxDepth(self, root):
        if root==None:
            return 0
        depth=0
        maxDeep=[]
        dfs(root,depth,maxDeep)
        return max(maxDeep)
        
        
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
print s.maxDepth(t1)