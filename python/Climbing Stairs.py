#########DP methods##########
def ways(n,result):
    if n==1:
        return 1
    if n==2:
        return 2
    if result[n]!=0:
        return result[n]
    result[n]=ways(n-1,result)+ways(n-2,result)
    return result[n]
class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
        result=[0]
        for i in range(n):
            result.append(0)
        return ways(n,result)

##########NO DP methods#########
# def ways(n):
#     if n==1:
#         return 1
#     if n==2:
#         return 2
#     if n>2:
#         return ways(n-1)+ways(n-2)
# class Solution:
#     # @param n, an integer
#     # @return an integer
#     def climbStairs(self, n):
#         return ways(n)
s=Solution()
print s.climbStairs(4)            