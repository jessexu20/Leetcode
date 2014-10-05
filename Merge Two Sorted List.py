class ListNode:
    def __init__(self,x=None,n=None):
        self.val=x
        self.next=n
class Solution:
    # @param two ListNodes
    # @return a ListNode
    def __init__(self):
        self.head=ListNode()
        self.last=self.head
        self.size=0
    def mergeTwoLists(self, l1, l2):
        if l1==None and l2==None:
            return None
        while l1!=None and l2!=None:
            if l1.val<=l2.val:
                value=l1.val
                l1=l1.next
            else:
                value=l2.val
                l2=l2.next
            node=ListNode(value)
            if self.head.val==None:
                self.head=node
                self.last=node
                self.size=1
            else:
                self.last.next=node
                self.last=node
                self.size=self.size+1    
        while l1!=None and l2==None:
            value=l1.val
            l1=l1.next
            node=ListNode(value)
            if self.head.val==None:
                self.head=node
                self.last=node
                self.size=1
            else:
                self.last.next=node
                self.last=node
                self.size=self.size+1
        while l2!=None and l1==None:
            value=l2.val
            l2=l2.next
            node=ListNode(value)
            if self.head.val==None:
                self.head=node
                self.last=node
                self.size=1
            else:
                self.last.next=node
                self.last=node
                self.size=self.size+1
        return self.head
    def traverse(self):
        p=self.head
        while(p!=None):
            print "p=",p.val
            p=p.next
                        
s=Solution()
l1node1 = ListNode(2)
l1node2 = ListNode(6)
l1node3 = ListNode(7)


l2node1 = ListNode(3)
l2node2 = ListNode(3)
l2node3 = ListNode(4)

l1node1.next=l1node2
l1node2.next=l1node3
l2node1.next=l2node2
l2node2.next=l2node3
a=s.mergeTwoLists(l1node1,l2node1)
print "size",s.size
s.traverse()