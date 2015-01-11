class Solution:
    # @return an integer
    def numTrees(self, n):
        result=[]
        result.append(1)
        result.append(1)
        for k in range(2,n+1):
            add=0
            for i in range(1,k+1):
                add+=(result[i-1]*result[k-i])
            result.append(add)
        print result
        return result[n]
s=Solution()
print s.numTrees(3)