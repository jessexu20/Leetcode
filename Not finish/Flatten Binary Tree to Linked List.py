# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def traverse(root):
    if root==None:
        return
    current=root
    while current!=None:
        print current.val,"->"
        current=current.right
def preorder(root,array):
    if root==None:
        return
    array.append(root)
    preorder(root.left,array)
    preorder(root.right,array)
        
        
class Solution:
    # @param root, a tree node
    # @return nothing, do it in place
    def flatten(self, root):
        nodeArray=[]
        head=root
        preorder(root,nodeArray)
        for i in range(len(nodeArray)):
            root.right=nodeArray[i]
            root=root.right
        traverse(head)
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
traverse(t1)