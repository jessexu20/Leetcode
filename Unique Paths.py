class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
        path=[[0 for i in range(n)] for j in range(m)]
        for i in range(n):
            path[0][i]=1
        for j in range(m):
            path[j][0]=1
        # print path
        for i in range(1,m):
            for j in range(1,n):
                path[i][j]=path[i-1][j]+path[i][j-1]
        return path[m-1][n-1]
        
        
s=Solution()
print s.uniquePaths(3,4)