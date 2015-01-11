class Solution:
    # @param digits, a list of integer digits
    # @return a list of integer digits
    def plusOne(self, digits):
        l=len(digits)
        i=l-1
        moveon=1
        while i>0:
            temp=digits[i]
            digits[i]=(digits[i]+moveon) % 10
            moveon=(temp+moveon) /10
            # print moveon
            i-=1
            if moveon==0:
                break
        if moveon==1:
            digits[0]+=1
            if digits[0]>9:
                digits[0]=digits[0] %10
                ans=[1]
                for i in digits:
                    ans.append(i)
                return ans
            else:
                return digits
        return digits
s=Solution()
print s.plusOne([9,9,9,9])
        
            
        