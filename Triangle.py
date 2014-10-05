class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        m=len(triangle)
        # for i in range(m):
        #     print triangle[i],'\n'
        result=[[None for i in range(m)] for j in range(m)]
        result[0][0]=triangle[0][0]
        for i in range(1,m):
            n=len(triangle[i])
            for j in range(n):
                tempList=[]
                if j==0:
                    result[i][j]=result[i-1][j]+triangle[i][j]
                    continue
                if j-1>=0:
                    tempList.append(result[i-1][j-1]+triangle[i][j])
                if result[i-1][j]!=None and j!=0:
                    tempList.append(result[i-1][j]+triangle[i][j])
                result[i][j]=min(tempList)
        # for i in range(len(result)):
            # print result[i],'\n'
        # print result
        return min(result[m-1])


lists=[[-7],[-2,1],[-5,-5,9],[-4,-5,4,4],[-6,-6,2,-1,-5],[3,7,8,-3,7,-9],
[-9,-1,-9,6,9,0,7],[-7,0,-6,-8,7,1,-4,9],[-3,2,-6,-9,-7,-6,-9,4,0],[-8,-6,-3,-9,-2,-6,7,-5,0,7],[-9,-1,-2,4,-2,4,4,-1,2,-5,5],
[1,1,-6,1,-2,-4,4,-2,6,-6,0,6],[-3,-3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1]]

# lists=[[-1],[3,2],[-3,1,-1]]
s=Solution()
print s.minimumTotal(lists)