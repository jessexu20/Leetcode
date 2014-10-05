def sets(self,arr,num):
    a=[]
    if num==1:
        for i in arr:
            a.append([i])
        return a
    a=(sets(arr,num-1))
    
    
    
    
    
class Solution:
    # @param S, a list of integer
    # @return a list of lists of integer
    def subsets(self, S):
        S.sort(reverse=True)
        l=len(S)
        ans=[[]]
        num=0
        i=0
        while num<l:
            length=len(ans)
            while i< length:
                number=S[num]
                # print S[num]
                add=ans[i]
                if number not in add:
                    add.append(number)
                    ans.append(add)
                    print ans
                i+=1
            num+=1
        return ans

s=Solution()
print s.subsets([1,2,3])