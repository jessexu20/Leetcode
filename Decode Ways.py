def check(string):
    if string[0]=="X" or string[1]=="X":
        print "false",string
        return False
    num=int(string)
    if num<27 and num>0:
        print "true",num
        return True
    else:
        print "false",num
        return False

class Solution:
    # @param s, a string
    # @return an integer
    def numDecodings(self, s):
        l=len(s)
        temp=""
        count=1
        if l==0:
            return 0
        if l==1 and s!="0":
            return 1
        if s[0]=="0":
            return 0
        for i in range(l-1):
            if s[i]=="0":
                if s[i+1]=="0":
                    return 0
                else:
                    continue
            if s[i+1]=="0":
                if s[i]!="1" and s[i]!="2":
                    print "here"
                    return 0
                else:
                    temp+="X"
            else:
                if s[i]!="0":
                    temp+=s[i]
        if s[l-1]!="0":
            temp+=s[l-1]
        # print temp
        lt=len(temp)
        for i in range(lt-1):
            if i+1<lt:
                if check(temp[i:i+2]):
                    count+=1
        return count
A="1212"
s=Solution()
print s.numDecodings(A)
                
        
        