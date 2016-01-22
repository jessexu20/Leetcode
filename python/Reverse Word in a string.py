class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        t=''
        if s!='':
            for i in range(len(s)-1):
                if (s[i]!=' ' or s[i+1]!=' '):
                    t=t+s[i]
            if s[len(s)-1]!=' ':
                t=t+s[len(s)-1]
        else:
            t=''
        #print(t,len(t))
        words=t.split(' ')
        box=[]
        a=''
        num=len(words)
        for i in range(num):
            #print(words[i])
            if words[i]!=' ':
                box.append(words[i])
        #print(box)
        num=len(box)
        #print(num)
        for i in range(num):
            a=a+(box[num-1-i])+' '
        if a==' ' or a=='':
            a=''
        return a
s=Solution()
print(s.reverseWords('a'))
