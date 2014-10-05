# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def inorder(root,ans,strArray,string):
    if root==None:
        return
    inorder(root.left,ans,strArray,"left")
    ans.append(root.val)
    strArray.append(string)
    inorder(root.right,ans,strArray,"right")
def checkSym(array):
    flag=True
    l=len(array)
    if l%2!=0:
        for i in range(l/2):
            if array[i]==array[-i-1]:
                continue
            else:
                # print "i",i,array[i],array[-1-i]
                flag=False
    else:
        return False
    return flag
def checkDif(array):
    flag=True
    l=len(array)
    if l%2==0:
        return False
    for i in range(l/2):
        if array[i]==array[-i-1]:
            return False
    return flag
class Solution:
    # @param root, a tree node
    # @return a boolean
    def isSymmetric(self, root):
        ans=[]
        strArray=[]
        inorder(root,ans,strArray,"root")
        # print ans
        # print strArray
        if len(ans)==0 or len(ans)==1:
            return True
        if checkSym(ans) and checkDif(strArray):
            return True
        else:
            return False
t1=TreeNode(1)
t2=TreeNode(2)
t3=TreeNode(2)
t4=TreeNode(3)
t5=TreeNode(3)
# t6=TreeNode(4)
t1.left=t2
t1.right=t3
t2.left=t4
t3.right=t5
# t3.left=t5
s=Solution()
print s.isSymmetric(t1)

