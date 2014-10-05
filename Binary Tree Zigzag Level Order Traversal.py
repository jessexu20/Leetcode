# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def level(root,ans,levelArray,levelNum):
    if root==None:
        return
    ans.append(root.val)
    levelArray.append(levelNum)
    level(root.left,ans,levelArray,levelNum+1)
    level(root.right,ans,levelArray,levelNum+1)
class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def zigzagLevelOrder(self, root):
        ans=[]
        levelArray=[]
        level(root,ans,levelArray,0)
        if ans==[] or levelArray==[]:
            return []
        # print ans
        # print levelArray
        maxLevel=max(levelArray)
        resultList=[[] for i in range(maxLevel+1)]
        # print resultList
        for i in range(len(levelArray)):
            resultList[levelArray[i]].append(ans[i])
        for i in range(maxLevel+1):
            if i % 2==1:
                resultList[i].reverse()
        return resultList
s=Solution()
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
print s.zigzagLevelOrder(t1)     
        