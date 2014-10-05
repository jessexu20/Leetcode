class Solution:
    # @param matrix, a list of lists of integers
    # RETURN NOTHING, MODIFY matrix IN PLACE.
    def setZeroes(self, matrix):
        rows=len(matrix)
        if rows==0:
            return []
        zerosRows={}
        zerosCols={}
        cols=len(matrix[0])
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j]==0:
                    if zerosRows.has_key(i)==False:
                        zerosRows[i]=1
                    if zerosCols.has_key(j)==False:
                        zerosCols[j]=1
        for i in range(rows):
            for j in range(cols):
                if zerosRows.has_key(i)==True or zerosCols.has_key(j)==True:
                    matrix[i][j]=0
        return
lists=[
    [1,0,2],
    [3,1,0],
    [1,2,3]
]        
s=Solution()
s.setZeroes(lists)
print lists
        
        
        
