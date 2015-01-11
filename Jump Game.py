class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        
        ################FIRST METHOD#############
        # l=len(A)
        # ans=[]
        # if l==1:
        #     return True
        # if A[0]!=0:
        #     ans[0]=1
        # else:
        #     return False
        # for i in range(l):
        #     ans.append(0)
        # for i in range(l-1):
        #     if A[i]==0:
        #         continue
        #     j=0
        #     while j<=A[i]:
        #         if j+i<l:
        #             ans[j+i]=1
        #             j+=1
        #         else:
        #             break
        # # print ans
        # if ans[l-1]==0:
        #     return False
        # else:
        #     return True
        # # print ans
        #
        
        
        ################SECOND METHOD#############
        # l=len(A)
        # ans=[]
        # for i in range(l):
        #     ans.append(0)
        # if l==1:
        #     return True
        # if A[0]!=0:
        #     ans[0]=1
        # else:
        #     return False
        # for i in range(l):
        #     for j in range(0,i):
        #         if j+A[j]>=i:
        #             ans[i]=1
        #             break
        # # print ans
        # if ans[l-1]==0:
        #     return False
        # else:
        #     return True
        # print ans
        
        ################THIRD METHOD#############
        maxHeight=0
        l=len(A)
        for i in range(l):
            if i>maxHeight:
                return False
            if i+A[i]>maxHeight:
                maxHeight=i+A[i]
        return True
        
A = [2,0]
B = [3,2,1,0,4]            
s=Solution()
print s.canJump(A)