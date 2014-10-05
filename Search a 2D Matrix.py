class Solution:
    # @param matrix, a list of lists of integers
    # @param target, an integer
    # @return a boolean
    def searchMatrix(self, matrix, target):
        r=len(matrix)
        if r==0:
            return False
        c=len(matrix[0])
        if c==0:
            return False
        for i in range(r):
            if matrix[i][0]>target:
                # print matrix[i-1][0]
                break
        if i==r-1:
            if matrix[i][0]<=target:
                if matrix[i-1][0]==target:
                    return True
            else:
                i=i-1
        else:
            i=i-1
        for j in range(c):
            # print matrix[i-1][j]
            if matrix[i][j]>target:
                # print matrix[i-1][j-1]
                break
        # print c,j
        if j==c-1:
            # print "here"
            if matrix[i][j]<=target:
                if matrix[i][j]==target:
                    return True
                else:
                    return False
            else:
                j=j-1
        else:
            j=j-1
        # print i,j,matrix[i][j]
        # print matrix[i-1][j]
        if matrix[i][j]==target:
            return True
        else:
            return False
        
        
        
lists=[[1,3,5]]
s=Solution()
print s.searchMatrix(lists,3)