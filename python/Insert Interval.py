# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution:
    # @param intervals, a list of Intervals
    # @param newInterval, a Interval
    # @return a list of Interval
    # Regarding to Merge Intervals
    def insert(self, intervals, newInterval):
        dic={}
        store={}
        value={}
        ans=[]
        intervals.append(newInterval)
        for i in intervals:
            begin=i.start
            end=i.end
            if store.has_key(begin)==False:
                store[begin]=1
            if store.has_key(end)==False:
                store[end]=1
            j=begin+1
            # print begin,end
            if begin==end:
                if dic.has_key(begin)==False:
                    dic[begin]=0.75
                    continue
                else:
                    continue
            if dic.has_key(begin)==False:
                dic[begin]=0.25
            elif dic.has_key(begin)==True:
                if dic[begin]==0.75 or dic[begin]==0.25:
                    dic[begin]=0.25
                else:
                    dic[begin]=1
            
            if dic.has_key(end)==False:
                dic[end]=0.5
            elif dic.has_key(end)==True:
                if dic[end]==0.75 or dic[end]==0.5:
                    dic[end]=0.5
                else:
                    dic[end]=1
            while j<end:
                if dic.has_key(j)==False or dic[j]==0.5 or dic[j]==0.25 or dic[j]==0.75:
                    dic[j]=1
                j+=1
            # print dic
        # print dic

        value=store.keys()
        # print value,"unsort"
        value.sort()
        # print value,"sorted"
        vl=len(value)
        for i in value:
            if dic[i]==0.75:
                continue
            dic[i]=0.25
            break
        # print dic,"this"
        for i in range(vl):
            if dic[value[-i-1]]==0.75:
                continue
            dic[value[-i-1]]=0.5
            break
        # print dic
        # print value
        p=-100000
        q=-100000
        for i in value:
            # print "i=",i
            if dic[i]==0.25:
                p=i
            elif dic[i]==0.5:
                q=i
                # print "q=",q
            elif dic[i]==0.75:
                xx=i
                ans.append(Interval(xx,xx))
            if p!=-100000 and q!=-100000:
                # print "p=",p,"q=",q
                temp=Interval(p,q)
                ans.append(temp)
                p=-100000
                q=-100000
                # print p,q
        return ans
        #dic initial complete
           
# i1=Interval(2,2)
# i2=Interval(0,2)
# i3=Interval(4,4)
# i4=Interval(0,1)
# i5=Interval(5,7)
# i6=Interval(4,5)
# i7=Interval(0,0)
testList=[[1,5]]
new=[6,8]
newInt=Interval(new[0],new[1])
I=[]
for i in testList:
    p=i[0]
    q=i[1]
    I.append(Interval(p,q))
# I=[i1,i2,i3,i4,i5,i6,i7]
s=Solution()
a=s.insert(I,newInt)
for i in a:
    print [i.start,i.end]
                