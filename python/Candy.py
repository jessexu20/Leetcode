class Solution:
    # @param ratings, a list of integer
    # @return an integer
    def candy(self, ratings):
        amount=[]
        r=[]
        ans=[]
        step=1
        for i in range(len(ratings)):
            amount.append(1)
            r.append(1)
            ans.append(1)
        for i in range(1,len(ratings)):
            if ratings[i]>ratings[i-1]:
                amount[i]=amount[i-1]+1
        #print('left',amount)
        for i in range(len(ratings)-1,0,-1):
            if ratings[i-1]>ratings[i]:
                r[i-1]=r[i]+1
        #print('right',r)
        for i in range(len(ratings)):
            #print(i,amount[i],r[i])
            ans[i]=max(amount[i],r[i])
        #print('ans',ans)
        return sum(ans)
        
s=Solution()
array=[2,1]
#print(array)
print(s.candy(array))
