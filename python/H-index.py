class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        dic={}
        for i in range(len(citations)):
            if dic.has_key(citations[i]):
                dic[citations[i]]+=1
            else:
                dic[citations[i]]=1
        citations.sort()
        newItems=[]
        h=-1
        for key in dic:
            if key not in newItems:
                newItems.append(key)
            if dic[key] not in newItems:
                newItems.append(dic[key])
        newItems.sort()
        for i in range(1,len(newItems)):
            temp=newItems[-1*i]
            if temp<len(citations) and citations[-1*temp]>=temp:
                h=temp
                break
        if len(citations)>0 and h==-1:
            h=0
        return h
        
        
s=Solution()
print s.hIndex([100])
        