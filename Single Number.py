class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        A.sort()
        print(A)
        for i in range(0,len(A)-1,2):
            if A[i]!=A[i+1]:
                return A[i]
        return A[len(A)-1]
s=Solution()
array=[1,2,3,3,2]
print(s.singleNumber(array))
