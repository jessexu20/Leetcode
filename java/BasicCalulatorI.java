import java.util.*;
public class BasicCalulatorI {
    public int calculate(String s) {
		int num=0;
		// int result=0;
		Stack<Integer> stack=new Stack();
		int sign=1;
		String temp="";
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
				temp+=s.charAt(i);
			}
			else if(s.charAt(i)=='+'){
				int n=(temp==""?0:Integer.valueOf(temp));
				num+=(sign*n);
				temp="";
				sign=1;
			}
			else if(s.charAt(i)=='-'){
				int n=(temp==""?0:Integer.valueOf(temp));
				num+=(sign*n);
				temp="";
				sign=-1;
			}
			else if(s.charAt(i)=='('){
				stack.push(num);
				stack.push(sign);
				temp="";
				num=0;
				sign=1;
			}
			else if (s.charAt(i)==')'){
				int n=(temp==""?0:Integer.valueOf(temp));
				num+=(sign*n);
				num*=stack.pop();
				num+=stack.pop();
				temp="";
			}
			else {
				if(temp!="")
					num+=sign*Integer.valueOf(temp);
				temp="";
			};
        }
		if(temp!="")
			num+=(sign*Integer.valueOf(temp));
		return num;
    }
	public static void main(String args[]){
		BasicCalulatorI bc= new BasicCalulatorI();
		System.out.println(bc.calculate("(1-(4-5+2)-3)+(6+8)"));
	}
}