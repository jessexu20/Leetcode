class Solution:
    # @param tokens, a list of string
    # @return an integer
    def evalRPN(self, tokens):
        length=len(tokens)
        array=[]
        for i in tokens:
            #print(i,type(i))
            if i!='+' and i!='-' and i!='*' and i!='/':
                array.append(int(i))
            else:
                #array.reverse()
                #print(array)
                a=array[-1]
                b=array[-2]
                #print("b=",b,i,"a=",a)
                del array[-2]
                del array[-1]
                #array.reverse()
                if i=='+':
                    array.append(b+a)
                if i=='-':
                    array.append(b-a)
                if i=='*':
                    array.append(a*b)
            	if i=='/':
                    array.append(int(float(b)/a))
            #print("array=",array)
        return array[0]
s=Solution()
print(s.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"]))