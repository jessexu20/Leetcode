class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2,s3):
        i=0
        j=0
        string=''
        while i<len(s1)-2 and j<len(s2)-2:
            string=string+s1[i:i+2]+s2[j:j+2]
            # print string
            j+=2
            i+=2
        if len(s1) %2==1 and len(s2)%2==1:
            string=string+s2[j]+s1[i]
        else:
            string=string+s1[i:i+2]+s2[j:j+2]
        if string==s3:
            return True
        else:
            return False
s=Solution()
s1="aabcc"
s2="dbbca"
s3="aadbbcbcac"

print s.isInterleave(s1,s2,s3)

            