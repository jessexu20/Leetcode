# Definition for singly-linked list.
def traverse(head):
    if head==None:
        return
    current=head
    while current!=None:
        print current.val,"->"
        current=current.next
def reverse(head):
    if head==None or head.next==None:
        return head
    cur=head.next
    head.next=None
    while cur!=None:
        t=cur.next
        cur.next=head
        head=cur
        cur=t
    return head
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return nothing

    def reorderList(self, head):
        if head==None:
            return head
        current=head
        l=0
        while current!=None:
            l+=1
            current=current.next
        halfL=l/2
        current=head
        while halfL>0:
            current=current.next
            halfL-=1
        half=current
        # print half.val
        reversedHalf=reverse(half.next)
        # traverse(reversedHalf)
        half.next=None
        current=head
        halfCurrent=reversedHalf
        while halfCurrent!=None:
            temp=current.next
            halfTemp=halfCurrent.next
            current.next=halfCurrent
            halfCurrent.next=temp
            current=temp
            halfCurrent=halfTemp
        return head
        
        
        # O(n^2)
        # cur=half
        # current=head
        # while current!=half:
        #     if cur.next==None:
        #         return head
        #     while cur.next.next!=None:
        #         cur=cur.next
        #     temp=current.next
        #     current.next=cur.next
        #     cur.next.next=temp
        #     current=temp
        #     cur.next=None
        #     cur=half
        # return head
        
    
        
        
        
l1=ListNode(1)
l2=ListNode(2)
l3=ListNode(3)
l4=ListNode(4)
l5=ListNode(5)
l6=ListNode(6)
# l7=ListNode(7)
l1.next=l2
l2.next=l3
l3.next=l4
l4.next=l5
l5.next=l6
# l6.next=l7
s=Solution()
a=s.reorderList(l1)
traverse(a)