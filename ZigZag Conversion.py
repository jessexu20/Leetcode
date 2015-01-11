class Solution:
    # @return a string
    def convert(self, s, nRows):
        l=len(s)
        if nRows==1:
            return s
        init=0
        i=0
        ans=""
        # print "l",l
        while init<nRows:
            if init==0 or init==nRows-1:
                i=init
                while i<l:
                    ans=ans+s[i]
                    i+=(2*nRows-2)
                init+=1
                # print ans
            else:
                i=init
                j=init+2*nRows-2*(1+init)
                firsttime=True
                while i<l and j<l:
                    # print i,j
                    if firsttime==True:
                        ans=ans+s[i]
                        firsttime=False
                        i+=2*nRows-2
                    else:
                        ans=ans+s[j]+s[i]  
                        i+=2*nRows-2
                        j+=2*nRows-2
                if j<l:
                    ans=ans+s[j]
                if i<l:
                    ans=ans+s[i]
                init+=1
        return ans
s=Solution()
print s.convert("AB", 3)