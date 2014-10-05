class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        string=str(x)
        i=0
        flag=True
        while i<len(string)/2:
            if string[i]!=string[-i-1]:
                flag=False
                return False
            else:
                i+=1
        return flag
s=Solution()
print s.isPalindrome(1221)