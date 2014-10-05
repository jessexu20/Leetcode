# Definition for a point
# import math
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b
def getK(m,n):
    if n[0]!=m[0]:
        k=float(float(n[1]-m[1])/float(n[0]-m[0]))
    else:
        k=None
    return k
def getB(m,n):
    k=getK(m,n)
    if k!=None:
        b=float(m[1]-float(k*m[0]))
    else:
        b=m[0]
    return b
class Solution:
    # @param points, a list of Points
    # @return an integer
    def maxPoints(self, points):
        dic={}
        pointP=[]
        add=[]
        l=len(points)
        if l<2:
            return l
        # for i in range(l):
        #     if (points[i].x,points[i].y) not in pointP:
        #         pointP.append((points[i].x,points[i].y))
        #     else:
        #         add.append((points[i].x,points[i].y))
        # print pointP
        # test only
        for i in points:
            if i not in pointP:
                pointP.append(i)
            else:
                add.append(i)
        # print pointP
        length=len(pointP)
        if length==1:
            return l
        for i in range(length-1):
            for j in range(i,length):
                if i!=j:
                    k=getK(pointP[i],pointP[j])
                    b=getB(pointP[i],pointP[j])
                    # print "(x1,y1)=",pointP[i],"(x2,y2)=",pointP[j],(k,b)
                    if dic.has_key((k,b)):
                        if pointP[j] not in dic[(k,b)]:
                            dic[(k,b)].append(pointP[j])
                    else:
                        dic[(k,b)]=[]
                        dic[(k,b)].append(pointP[i])
                        dic[(k,b)].append(pointP[j])
        # print "\n","dic",dic,"add",add
        for i in dic:
            for j in add:
                if j in dic[i]:
                    dic[i].append(j)
            dic[i]=len(dic[i])
        return max(dic.values())

s=Solution()
# p1=Point(1,1)
# p2=Point(1,1)
# p3=Point(2,2)
# p4=Point(2,2)
# # p5=Point(4,5)
# # p6=Point(4,6)
# points=[p1,p2,p3,p4]# ,p3,p4,p5,p6]
points=[(0,-12),(5,2),(2,5),(0,-5),(1,5),(2,-2),(5,-4),(3,4),(-2,4),(-1,4),(0,-5),(0,-8),(-2,-1),(0,-11),(0,-9)]
print s.maxPoints(points)
            