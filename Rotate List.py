# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def rotateRight(self, head, k):
        length=1
        current=head
        if current==None:
            return None
        while current.next!=None:
            length+=1
            current=current.next
        # print length
        tail=current
        k=k%length
        if k==0:
            return head
        num=length-k
        current=head
        while num>1:
            current=current.next
            num-=1
        t=current.next
        current.next=None
        tail.next=head
        head=t
        return head
    def traverse(self,head):
        current=head
        while current!=None:
            print current.val
            current=current.next
s=Solution()
x1=ListNode(1)
x2=ListNode(2)
x3=ListNode(3)
x4=ListNode(4)
x5=ListNode(5)
x6=ListNode(4)
x7=ListNode(5)
x1.next=x2
x2.next=x3
x3.next=x4
x4.next=x5
x5.next=x6
x6.next=x7
a=s.rotateRight(x1,3)
s.traverse(a)


        
        
            
        