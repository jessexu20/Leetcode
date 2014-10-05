def addNum(a,n):
    if n==1:
        a.append('1')
        return
    addNum(a,n-1)
    s=a[-1]+'e'
    count=[]
    number=[]
    string=''
    length=1
    for i in range(len(s)-1):
        if s[i]==s[i+1]:
            length+=1
        else:
            number.append(s[i])
            count.append(length)
            length=1
    for i in range(len(count)):
        string=string+str(count[i])+str(number[i])
    a.append(string)
    n-=1
class Solution:
    # @return a string
    def countAndSay(self, n):
        ans=[]
        addNum(ans,n)
        return ans[n-1]
    
s=Solution()
print s.countAndSay(4)       
            