def comb(candidates,target,dic):
    if dic.has_key(target):
        return target
class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def combinationSum(self, candidates, target):
        dic={}
        l=len(candidates)
        for i in candidates:
            dic[i]=1
        ans=[]
        i=0
        keys=dic.keys()
        t=target
        temp=[]
        while keys[i]<t:
            j=i
            temp.append(keys[i])
            t=dic[keys[i]]
            while j<l:
                
        