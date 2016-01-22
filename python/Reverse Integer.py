class Solution:
    # @return an integer
    def reverse(self, x):
        if x>=0:
            y=0
            length=len(str(x))
            #print(length)
            for i in range(length):
                digi=int(x/(10**(length-1-i)))
                #print('digi=',digi)
                x=x-digi*(10**(length-1-i))
                #print('x=',x)
                y=y+digi*(10**i)
                #print('y=',y)
            #print('ans=',y)
            return y
        else:
            x=-x
            y=0
            length=len(str(x))
            #print(length)
            for i in range(length):
                digi=int(x/(10**(length-1-i)))
                #print('digi=',digi)
                x=x-digi*(10**(length-1-i))
                #print('x=',x)
                y=y+digi*(10**i)
                #print('y=',y)
            #print('ans=',y)
            y=-y
            return y
s=Solution()
print(s.reverse(-1235542))
