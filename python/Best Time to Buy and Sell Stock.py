class Solution:
    # @param prices, a list of integer
    # @return an integer      
    def maxProfit(self, prices):
        m=prices[0]
        profit=0
        for i in range(len(prices)):
            m=min([m,prices[i]])
            profit=max([profit,prices[i]-m])
            #print ('a=',a,'b=',b,'max=',a-b)
        return profit
s=Solution()
print(s.maxProfit([2,3,4,1,2,3,8,5]))
