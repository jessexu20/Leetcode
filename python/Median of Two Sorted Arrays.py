class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
        i=0
        j=0
        n=0
        p=len(A)
        q=len(B)
        while len(A)!=len(B):
            if len(A)<len(B):
                A.append(1000000000)
            else:
                B.append(1000000000)
        ans=[]
        while(i<len(A) and j<len(B)):
            # print "ans",ans
            if A[i]<=B[j]:
                ans.append(A[i])
                i+=1
                n+=1
            else:
                ans.append(B[j])
                j+=1
                n+=1
            if n==(p+q)/2+1:
                if (p+q)%2==1:
                    # print n,ans
                    return ans[n-1]
                else:
                    return float(ans[n-2]+ans[n-1])/2
        while i==len(A) or j==len(B) and n<(p+q)/2+1:
            if i==len(B):
                ans.append(B[j])
                j+=1
                n+=1
            else:
                ans.append(A[i])
                i+=1
                n+=1
            if n==(p+q)/2+1:
                if (p+q)%2==1:
                    # print n,ans
                    return ans[n-1]
                else:
                    return float(ans[n-2]+ans[n-1])/2
s=Solution()
A=[1]
B=[1]
print s.findMedianSortedArrays(A,B)
                
                
        