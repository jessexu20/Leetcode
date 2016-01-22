# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    # def insertionSortList(self, head):
    #     if head==None:
    #         return None
    #     else:
    #         currentNode=ListNode(-100000)
    #         while(head!=None):
    #             value=head.val
    #             newNode=ListNode(value)
    #             if currentNode.next==None:
    #                 currentNode.next=newNode
    #                 headNode=currentNode
    #                 head=head.next
    #             else:
    #                 while value>currentNode.next.val:
    #                     currentNode=currentNode.next
    #                     if currentNode.next==None:
    #                         break
    #                 newNode.next=currentNode.next
    #                 currentNode.next=newNode
    #                 head=head.next
    #                 currentNode=headNode
    #         return headNode.next
    def insertionSortList(self, head):
        if head==None:
            return None
        headNode=ListNode(-100000)
        headNode.next=head
        curNode=head
        while curNode.next:
            if curNode.next.val<curNode.val:
                pre=headNode
                while pre.next.val<curNode.next.val:
                    pre=pre.next
                t=curNode.next
                curNode.next=t.next
                t.next=pre.next
                pre.next=t
            else:
                curNode=curNode.next
        return headNode.next   
            
            
            
    def traverse(self,head):
        while(head!=None):
            print head.val
            head=head.next
            
            
s=Solution()
testNode1=ListNode(4)
testNode2=ListNode(2)
testNode3=ListNode(5)
testNode4=ListNode(0)
testNode5=ListNode(-1)
testNode6=ListNode(2)
testNode1.next=testNode2
testNode2.next=testNode3
testNode3.next=testNode4
testNode4.next=testNode5
testNode5.next=testNode6
a=s.insertionSortList(testNode1)
s.traverse(a)
                
                    