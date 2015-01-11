# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def searchPath(root,sumVal,p,path,ans):
    if root==None:
        return
    p.append(root.val)
    root.val=root.val+sumVal
    if root.left==None and root.right==None:
        ans.append(root.val)
        # print "here",p
        path.append(list(p))
        # print path
    searchPath(root.left,root.val,p,path,ans)
    searchPath(root.right,root.val,p,path,ans)
    p.pop()
    
class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a list of lists of integers
    def pathSum(self, root, sum):
        path=[]
        ans=[]
        p=[]
        searchPath(root,0,p,path,ans)
        ansList=[]
        for i in range(len(ans)):
            if ans[i]==sum:
                ansList.append(path[i])
        return ansList
        
t1=TreeNode(5)
t2=TreeNode(4)
t3=TreeNode(8)
t4=TreeNode(11)
t5=TreeNode(13)
t6=TreeNode(4)
t7=TreeNode(7)
t8=TreeNode(2)
t9=TreeNode(1)
t10=TreeNode(5)
t1.left=t2
t2.left=t4
t4.left=t7
t4.right=t8
t1.right=t3
t3.left=t5
t3.right=t6
t6.right=t9
t6.left=t10

s=Solution()
print s.pathSum(t1,22)        