class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of integers
    def spiralOrder(self, matrix):
        m=len(matrix)
        if m==0:
            return []
        n=len(matrix[0])
        ans=matrix[0]
        i=1
        j=n-1
        moveStepV=m-1
        moveStepH=n-1
        
        while min(moveStepH,moveStepV)>=0:
            
            count=1
            while count<=moveStepV and moveStepH>=0:
                ans.append(matrix[i][j])
                i+=1
                count+=1
            i-=1
            j-=1
            moveStepV-=1
            
            count=1
            while count<=moveStepH and moveStepV>=0:
                ans.append(matrix[i][j])
                j-=1
                count+=1
            j+=1
            i-=1
            moveStepH-=1
            
            count=1
            while count<=moveStepV and moveStepH>=0:
                ans.append(matrix[i][j])
                i-=1
                count+=1
            i+=1
            j+=1
            moveStepV-=1
            
            count=1
            while count<=moveStepH and moveStepV>=0:
                ans.append(matrix[i][j])
                j+=1
                count+=1
            j-=1
            i+=1
            moveStepH-=1

        return ans
lists=[
 [ 1, 2]
]
s=Solution()
print s.spiralOrder(lists)
                
                
            
        
        
            