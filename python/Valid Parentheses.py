def match(a,b):
    if a=="(" and b==")":
        return True
    elif a=="{" and b=="}":
        return True
    elif a=="[" and b=="]":
        return True
    else:
        return False
class Solution:
    # @return a boolean
    def isValid(self, s):
        temp=[]
        l=len(s)
        if l % 2!=0:
            return False
        for i in s:
            if i=="(" or i=="[" or i=="{" :
                temp.append(i)
            else:
                if temp==[]:
                    return False
                t=temp.pop()
                if match(t,i)==False:
                    return False
        if temp==[]:
            return True
        else:
            return False


string=")}{({))[{{[}"                
s=Solution()
print s.isValid(string)