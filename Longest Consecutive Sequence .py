class Solution:
    # @param num, a list of integer
    # @return an integer
    def longestConsecutive(self, num):
        if len(num)==1:
            return 1
        else:
            num.sort(reverse=True)
            maxlen=1
            length=1
            for i in range(len(num)-1):
                if num[i]==num[i+1]:
                    continue
                elif num[i]==num[i+1]+1:
                    length=length+1
                else:
                    if length>maxlen:
                        maxlen=length
                    length=1
                print "length=",length,"max",maxlen
                print num
            if length>maxlen:
                return length
            else:
                return maxlen
s=Solution()
print s.longestConsecutive([0,1,3,4,3,5])