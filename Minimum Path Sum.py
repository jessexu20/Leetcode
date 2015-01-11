class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
        l=len(grid)
        w=len(grid[0])
        if l==0 or w==0:
            return 0
        if l==1 and w==1:
            return grid[0][0]
        for j in range(1,w):
            grid[0][j]=grid[0][j]+grid[0][j-1]
        for i in range(1,l):
            grid[i][0]=grid[i][0]+grid[i-1][0]
        for i in range(1,l):
            for j in range(1,w):
                grid[i][j]=grid[i][j]+min(grid[i-1][j],grid[i][j-1]) 
        # print grid
        return grid[l-1][w-1]       
            
        
        
        
s=Solution()
lists=[[i for i in range(5)] for j in range(10)]
print lists
print s.minPathSum(lists)