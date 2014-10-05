# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        head1=l1
        head2=l2
        cur1=head1
        cur2=head2
        ansHead=ListNode(-10000)
        current=ansHead
        flag=0
        while(cur1!=None and cur2!=None):
            if cur1.next==None:
                while(cur2.next!=None):
                    cur1.next=ListNode(0)
                    cur1=cur1.next
                    cur2=cur2.next
            if cur2.next==None:
                while(cur1.next!=None):
                    cur2.next=ListNode(0)
                    cur2=cur2.next
                    cur1=cur1.next
            cur1=cur1.next
            cur2=cur2.next
        cur1=head1
        cur2=head2
        while(cur1!=None and cur2!=None):
            value=(cur1.val+cur2.val+flag)%10
            flag=(cur1.val+cur2.val+flag)/10
            current.next=ListNode(value)
            current=current.next
            cur1=cur1.next
            cur2=cur2.next
        if flag!=0:
            current.next=ListNode(1)
        return ansHead.next
    def traverse(self,head):
        cur=head
        while(cur!=None):
            print cur.val
            cur=cur.next
s=Solution()
x1=ListNode(9)
x2=ListNode(4)
x3=ListNode(9)
x1.next=x2
x2.next=x3

y1=ListNode(1)
y2=ListNode(6)
# y3=ListNode(5)
y1.next=y2

a=s.addTwoNumbers(x1,y1)
s.traverse(a)
