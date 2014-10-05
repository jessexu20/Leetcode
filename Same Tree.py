# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def inorder(root,ans,stringArray,string):
    if root==None:
        return
    inorder(root.left,ans,stringArray,"left")
    ans.append(root.val)
    stringArray.append(string)
    inorder(root.right,ans,stringArray,"right")
    return ans
def preorder(root,ans):
    if root==None:
        return
    ans.append(root.val)
    preorder(root.left,ans)
    preorder(root.right,ans)
    return ans
class Solution:
    # @param p, a tree node
    # @param q, a tree node
    # @return a boolean
    def isSameTree(self, p, q):
        inorderArray=[]
        preorderArray=[]
        inorderArray2=[]
        preorderArray2=[]
        stringArray=[]
        stringArray2=[]
        inorder(p,inorderArray,stringArray,"root")
        preorder(p,preorderArray)
        inorder(q,inorderArray2,stringArray2,"root")
        preorder(q,preorderArray2)        
        if inorderArray == inorderArray2 and preorderArray == preorderArray2 and stringArray==stringArray2:
            return True
        else:
            return False


t1=TreeNode(1)
t2=TreeNode(2)
t3=TreeNode(2)
t4=TreeNode(3)
t5=TreeNode(3)
t1.left=t2
t1.right=t3
t2.left=t4
t3.right=t5
s=Solution()
print s.isSameTree(t1,t2)