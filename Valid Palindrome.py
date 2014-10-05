class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        if len(s)==1 or len(s)==0:
            return True
        s=s.lower()
        string=""
        for i in s:
            if i>='a' and i<='z' or i>='0' and i<='9':
                string=string+i
        l=len(string)
        i=0
        j=l-1
        flag=True
        while i<=l/2 and j>=l/2:
            if string[i]!=string[j]:
                flag=False
                break
            # print l,string[i],string[j]
            i+=1
            j-=1
        return flag
        
        
s=Solution()
A="A man, a plan, a anal: Panama"
B="race a car"
print s.isPalindrome(B)