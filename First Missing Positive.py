class Solution:
    # @param A, a list of integers
    # @return an integer
    def firstMissingPositive(self, A):
        l=len(A)
        minPos=1000000
        if l==0:
            return 1
        dic={}
        for i in A:
            if dic.has_key(i)==False:
                dic[i]=1
            if i>=0 and i<minPos:
                minPos=i
        # print dic
        if minPos==1000000:
            minPos=1
        for i in range(1,minPos+l+1):
            if dic.has_key(i)==False:
                return i
                
array=[4,-2]               
s=Solution()
print s.firstMissingPositive(array)