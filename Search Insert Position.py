class Solution:
    # @param A, a list of integers
    # @param target, an integer to be inserted
    # @return integer
    def searchInsert(self, A, target):
        i=0
        while i<=(len(A)):
            # print i
            if target==A[i]:
                return i
            elif A[i]<target:
                i+=1
            if i==len(A) or A[i]>target:
                break
        return i
s=Solution()
A=[1,3,5,6]
print s.searchInsert(A,9)
        