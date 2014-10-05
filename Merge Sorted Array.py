# Given two sorted integer arrays A and B, merge B into A as one sorted array.
class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        C=[]
        for i in range(m):
            C.append(A[i])
        i=0
        j=0
        k=0
        while k<m+n:
            if i<m and j<n:
                if C[i]<=B[j]:
                    A[k]=C[i]
                    i=i+1
                    k=k+1
                else:
                    A[k]=B[j]
                    j=j+1
                    k=k+1
            elif i==m:
                A[k]=B[j]
                j=j+1
                k=k+1
            elif j==n:
                A[k]=C[i]
                i=i+1
                k=k+1
s=Solution()
A=[2,3,5,6,9,1,1,1,1]
B=[3,4,7,8]
m=5
n=4
s.merge(A,m,B,n)
print A