# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        listhead=ListNode(-1000000)
        p=listhead
        q=listhead
        listhead.next=head
        while p.next!=None:
            if p.next.next==None:
                return listhead.next
            if p.next.val==p.next.next.val:
                while p.next.val==p.next.next.val:
                    t=p.next.next
                    p.next.next=t.next
                    if p.next.next==None:
                        break
                t=q.next
                q.next=t.next
            else:
                p=p.next
                q=q.next
        return listhead.next
    def traverse(self,head):
        current=head
        while current!=None:
            print current.val
            current=current.next
        
s=Solution()
x1=ListNode(1)
x2=ListNode(1)
x3=ListNode(3)
x4=ListNode(3)
x5=ListNode(4)
x6=ListNode(4)
x7=ListNode(5)
x1.next=x2
x2.next=x3
x3.next=x4
x4.next=x5
x5.next=x6
x6.next=x7

a=s.deleteDuplicates(x1)
s.traverse(a)
                