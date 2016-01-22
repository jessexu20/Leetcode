class Solution:
    # @param A a list of integers
    # @return nothing, sort in place
    def sortColors(self, A):
        p=-1
        q=-1
        for i in range(len(A)):
            v=A[i]
            A[i]=2
            if v==0:
                q+=1
                A[q]=1
                p+=1
                A[p]=0
            elif v==1:
                q+=1
                A[q]=1
                
s=Solution()
A=[0,1,1,1,0,1,2,1,2,1]
s.sortColors(A)
print A