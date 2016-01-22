# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        if head==None:
            return None
        else:
            node=ListNode(0)
            node=head
            while node.next!=None:
                value=node.next.val
                if node.val==value:
                    node.next=node.next.next
                else:
                    node=node.next
                # if node==None:
                #     del node
                #     return head
            return head
    def traverse(self,head):
        node=ListNode(0)
        node=head
        while(node!=None):
            print node.val
            node=node.next
s=Solution()
testNode1=ListNode(1)
testNode2=ListNode(1)
testNode3=ListNode(1)
testNode4=ListNode(2)
testNode1.next=testNode2
testNode2.next=testNode3
testNode3.next=testNode4

s.deleteDuplicates(testNode1)
s.traverse(testNode1)