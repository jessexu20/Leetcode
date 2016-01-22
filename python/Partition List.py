# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @param x, an integer
    # @return a ListNode
    def partition(self, head, x):
        current=head
        before=ListNode(-10000)
        after=ListNode(-10000)
        # mid=ListNode(x)
        curb=before
        cura=after
        while current!=None:
            if current.val<x:
                curb.next=ListNode(current.val)
                curb=curb.next
                current=current.next
            else:
                cura.next=ListNode(current.val)
                cura=cura.next
                current=current.next
        if before.next==None and after.next!=None:
            return after.next
        head=before.next
        curb.next=after.next
        return head
    def traverse(self,head):
        current=head
        while(current!=None):
            print current.val
            current=current.next
            
            
# Given 1->4->3->2->5->2 and x = 3,
# return 1->2->2->4->3->5.        
        
s=Solution()
x1=ListNode(1)
x2=ListNode(4)
x3=ListNode(3)
x4=ListNode(2)
x5=ListNode(5)
x6=ListNode(2)
x1.next=x2
x2.next=x3
x3.next=x4
x4.next=x5
x5.next=x6
a=s.partition(x1,3)
s.traverse(a)
            
                