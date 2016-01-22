class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        if numRows==0:
            return []
        if numRows==1:
            return [[1]]
        if numRows==2:
            return [[1],[1,1]]
        ans=[[1],[1,1]]
        for i in range(3,numRows+1):
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
        return ans
s=Solution()
print s.generate(7)