
# O(N^2)
class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        # for i in range(len(num)):
        #     for j in range(i,len(num)):
        #         if num[i]+num[j]==target:
        #             return(i+1,j+1)
        dic={}
        ansList=[]
        for i in range(len(num)):
            if dic.has_key(num[i]):
                ansList.append([target,dic[num[i]]+1,i+1])
            else:
                dic[target-num[i]]=i 
        return ansList
s=Solution()
print s.twoSum([2, -4, -3, -9,15],-7)