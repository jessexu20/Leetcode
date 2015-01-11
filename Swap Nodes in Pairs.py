# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param a ListNode
    # @return a ListNode
    def swapPairs(self, head):
        if head==None or head.next==None:
            return head
        h=ListNode(-100000)
        h.next=head
        current=h
        while current.next!=None:
            p=current.next
            if p.next!=None:
                q=p.next
                if q!=None:
                    temp=q.next
                    current.next=q
                    q.next=p
                    p.next=temp
                else:
                    break
            else:
                break
            current=current.next.next
        return h.next
    def traverse(self,head):
        if head==None:
            return
        current=head
        while current!=None:
            print current.val,"->"
            current=current.next
            
l1=ListNode(1)
l2=ListNode(2)
l3=ListNode(3)
l4=ListNode(4)
l1.next=l2
l2.next=l3
l3.next=l4
s=Solution()
a=s.swapPairs(l1)
s.traverse(a)
        