class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if len(prices)<2:
            return 0
        else:
            check=[]
            check.append(1)
            buy=[]
            sum=0
            odd=0
            flag=1;
            #print(prices,type(prices))
            for i in range(1,len(prices)):
                if prices[i]>prices[i-1]:
                    check.append(1)
                else:
                    check.append(0)
            #print(check,type(check))
            if check[1]==1:
                buy.append(1)
            else:
                buy.append(0)
            for i in range(1,len(check)-1):
                buy.append(check[i] ^ check[i+1])
            #print(buy)
            for i in buy:
                odd+=i
            if odd%2!=0:
                buy.append(1)
            for i in range(len(buy)):
                if buy[i]==1:
                    flag*=-1
                    sum+=prices[i]*flag;
            return sum
        
s=Solution()
print(s.maxProfit([1,2]))
