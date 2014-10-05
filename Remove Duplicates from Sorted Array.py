class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        k=0
        i=0
        while i <(len(A)):
            j=i
            n=0
            while j<len(A)-1 and A[j]==A[j+1]:
                n+=1
                j+=1
            #if n!=0:
                #for t in range(i,len(A)-n):
                #    A[t]=A[t+n]
                #for k in range(n):
                #    A[len(A)-k-1]='a'
            if n==0:
                A[k]=A[i]
            else:
                i=j
                A[k]=A[j]
            k+=1
            print('A=',A,'k=',k,'i=',i)
            i+=1
        return k
s=Solution()
print(s.removeDuplicates([1,2,2,2,3,3,4,4,4,4,5,5,5,6,6,7]))
