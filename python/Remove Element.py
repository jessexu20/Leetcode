class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        n=A.count(elem)
        while n>0:
            A.remove(elem)
            n-=1
        l=len(A)-n
        return l