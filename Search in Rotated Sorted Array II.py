class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return an integer
    def search(self, A, target):
        l=len(A)
        if l==0:
            return -1
        if l==1:
            if A[0]!=target:
                return -1
            else:
                return 0
        if target>=A[0]:
            flag=True
        else:
            flag=False
        if flag==True:
            i=0
            while i<l-1 and A[i]<=A[i+1]:
                if A[i]==target:
                    return i
                i+=1
            if A[i]==target:
                return i
            return -1
        else:
            i=-1
            while l+i>0 and A[i]>=A[i-1]:
                if A[i]==target:
                    return l+i
                i-=1
            if A[i]==target:
                return l+i
            return -1
array=[2,2,3]
s=Solution()
print s.search(array,3)        