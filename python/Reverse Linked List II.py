# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @param m, an integer
    # @param n, an integer
    # @return a ListNode
    def reverseBetween(self, head, m, n):
        cur=head
        revst=head
        reved=head
        array=[]
        rangem=m
        rangen=n
        while(rangem>1):
            revst=cur
            cur=cur.next
            rangem-=1
        if m==1: 
            reved=revst         
            while(rangen-m>0):
                array.append(cur.val)
                cur=cur.next
                reved=cur 
                rangen-=1
            array.append(reved.val)
            current=head
            if len(array)==0:
                return head
            else:
                current.val=array[-1]
            for i in range(len(array)-1):
                current.next=ListNode(array[-i-2])
                current=current.next
            current.next=reved.next
            return head
        else:
            reved=revst         
            while(rangen-m>=1):
                array.append(cur.val)
                cur=cur.next
                reved=cur 
                rangen-=1
            if n-m>0:
                array.append(reved.val)
            current=revst
            print "current",current.val,"array",array
            if len(array)==0:
                return head
            else:
                for i in range(len(array)):
                    current.next=ListNode(array[-i-1])
                    current=current.next
                current.next=reved.next
                return head
            # print "start",revst.next.val,"end",reved.val,"array",array
    def traverse(self,head):
        current=head
        while(current!=None):
            print current.val
            current=current.next
x1=ListNode(3)
x2=ListNode(5)
# x3=ListNode(3)
# x4=ListNode(4)
# x5=ListNode(5)
# x6=ListNode(6)
x1.next=x2
# x2.next=x3
# x3.next=x4
# x4.next=x5
# x5.next=x6

s=Solution()
ans=s.reverseBetween(x1,2,2)
s.traverse(ans)

            