# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
def traverse(head):
    if head==None:
        return
    current=head
    while current!=None:
        print current.val,"->"
        current=current.next
class Solution:
    # @return a ListNode
    def removeNthFromEnd(self, head, n):
        if head==None:
            return head
        current=head
        size=1
        while current!=None:
            size+=1
            current=current.next
            if size==n+1:
                pos=head
                break
        if current==None:
            return head.next
        while current.next!=None:
            current=current.next
            pos=pos.next
        pos.next=pos.next.next
        return head

l1=ListNode(1)
l2=ListNode(2)
l3=ListNode(3)
l4=ListNode(4)
l5=ListNode(5)
l6=ListNode(6)
l7=ListNode(7)
l1.next=l2
l2.next=l3
l3.next=l4
l4.next=l5
l5.next=l6
l6.next=l7

s=Solution()
a=s.removeNthFromEnd(l1,7)
traverse(a)      