def checkp (string):
    for i in range(len(string)):
        if string[i]==string[-1-i]:
            # print "in check",string
            continue
        else:
            return False
    return True
class Solution:
    # @param s, a string
    # @return a list of lists of string
    def partition(self, s):
        l=[]
        ll=[]
        print len(s),range(len(s))
        for i in range(len(s)):
            string=s[i:len(s)-i]
            if checkp(string)==1:
                print "string",string,"TRUE"
                l.append(string)
            else:
                print l,"FALSE"
            ll.append(l)
        return ll
    
                
            
            
s=Solution()
print s.partition("aab")