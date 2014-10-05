class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        m=len(a)
        n=len(b)
        maxlen=m
        string=""
        if m!=n:
            if m>n:
                maxlen=m
                gap=m-n
                while gap>0:
                    b='0'+b;
                    gap-=1
            else:
                maxlen=n
                gap=n-m
                while gap>0:
                    a='0'+a;
                    gap-=1
        # print a,b
        i=maxlen-1
        c=0
        ans=0
        while i>=0:
            x=int(a[i])
            y=int(b[i])
            ans=(x+y+c)%2
            if x+y+c>=2:
                c=1
            else:
                c=0
            # print "ans",ans,"c",c
            string=str(ans)+string
            if i==0 and c!=0:
                string=str(c)+string
            i-=1
            
        return string
        
        
s=Solution()
A="1"
B="1"
print s.addBinary(A,B)