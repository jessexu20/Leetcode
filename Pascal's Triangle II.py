class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        if rowIndex==0:
            return [1]
        if rowIndex==1:
            return [1,1]
        ans=[[1],[1,1]]
        for i in range(3,rowIndex+2):
            ans.append([0 for i in range(i)])
            for j in range(i+1):
                if j==0:
                    ans[i][j]=1
                elif j==i:
                    ans[i][j]=1
                else:
                    ans[i][j]=ans[i-1][j-1]+ans[i-1][j]
            # print ans
            # ans.append([ans[i][]])
        return ans[rowIndex]
s=Solution()
print s.getRow(2)