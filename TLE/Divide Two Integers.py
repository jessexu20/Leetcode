class Solution:
    # @return an integer
    def divide(self, dividend, divisor):
        ans=0
        positive=True
        if divisor<0 and dividend>0:
            positive=False
            divisor=-divisor
        elif divisor>0 and dividend<0:
            positive=False
            dividend=-dividend
        elif divisor<0 and dividend<0:
            dividend=-dividend
            divisor=-divisor
        if divisor==1:
            return dividend
        elif divisor==-1:
            return -dividend
        while dividend>=divisor:
            dividend-=divisor
            ans+=1
        if positive==False:
            return -ans
        else:
            return ans
s=Solution()
print s.divide(-1,-1)