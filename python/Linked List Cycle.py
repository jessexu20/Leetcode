# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a boolean
    def hasCycle(self, head):
        cur=head
        curdouble=head
        while(cur!=None and curdouble!=None):
            cur=cur.next
            curdouble=curdouble.next
            if curdouble!=None:
                curdouble=curdouble.next
            else:
                return False
            if(cur==curdouble and cur!=None):
                return True
        return False
