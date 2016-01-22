def twoSum(self, num, target, index):
    dic={}
    ansList=[]
    for i in range(len(num)):
        if dic.has_key(num[i]) and dic[num[i]]!=index and i!=index:
            ansList.append([-target,num[dic[num[i]]],num[i]])
        else:
            dic[target-num[i]]=i
    return ansList
class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        listNum=[]
        if len(num)<3:
            return []
        for i in range(len(num)):
            temp=num[i]
            if i<len(num)-1:
                if temp==num[i+1]:
                    continue
            ts=twoSum(self,num,-temp,i)
            if ts!=None:
                for j in ts:
                    j.sort()
                    if not j in listNum:
                        listNum.append(j)
        return listNum
        
        
s=Solution()
A=[-12,4,12,-4,3,2,-3,14,-14,3,-12,-7,2,14,-11,3,-6,6,4,-2,-7,8,8,10,1,3,10,-9,8,5,11,3,-6,0,6,12,-13,-11,12,10,-1,-15,-12,-14,6,-15,-3,-14,6,8,-9,6,1,7,1,10,-5,-4,-14,-12,-14,4,-2,-5,-11,-10,-7,14,-6,12,1,8,4,5,1,-13,-3,5,10,10,-1,-13,1,-15,9,-13,2,11,-2,3,6,-9,14,-11,1,11,-6,1,10,3,-10,-4,-12,9,8,-3,12,12,-13,7,7,1,1,-7,-6,-13,-13,11,13,-8]
print s.threeSum(A)



