class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        A.sort()
        #print(A)
        for i in range(0,len(A)-1,3):
            if A[i]!=A[i+1] or A[i]!=A[i+2]:
                return A[i]
        return A[len(A)-1]
s=Solution()
print(s.singleNumber([1,1,2,1,2,2,4]))
