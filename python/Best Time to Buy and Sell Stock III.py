class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if len(prices)<2:
            return 0
        profit=[0,0]
        p=0
        m=prices[0]
        for i in range(len(prices)):
            m=min([m,prices[i]])
            p=prices[i]-m
            print(p)
            if p>profit[0]:
                profit[0]=p
                profit.sort(reverse=False)
                print(profit)
        print(profit)
        
s=Solution()
x=[1,2,4,2,5,7,2,4,9,0]
print(s.maxProfit(x))
