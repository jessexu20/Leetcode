def search(A,left,right,target):
    mid=(left+right)/2
    print mid,A[mid]
    if A[mid]==target:
        return mid
    if left==right or left==right-1:
        if A[left]!=target and A[right]!=target:
            return None
        elif A[left]==target:
            return left
        elif A[right]==target:
            return right
    if target>A[mid]:
        return search(A,mid,right,target)
    else:
        return search(A,left,mid,target)
class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
        l=len(A)
        index=search(A,0,l-1,target)
        if index==None:
            return [-1,-1]
        i=0
        j=0
        begin=index
        end=index
        while index-i>=0 and A[index-i]==target:
            begin=index-i
            i+=1
        while index+j<l and A[index+j]==target:
            end=index+j
            j+=1
        return [begin,end]
        
array=[1,2,2,2,3] 
target=2
s=Solution()
print s.searchRange(array,target)
        