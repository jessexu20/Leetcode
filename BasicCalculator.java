import java.util.Stack;
public class BasicCalculator {
    public int calculate(String s) {
        Stack <Integer> stack= new Stack();
		int length=s.length();
		if (length<=0)
			return 0;
		int number= 0;
		int result= 0;
		int sign =1;
		for (int i=0;i<length;i++){
			char x=s.charAt(i);
			if (x<='9' && x>='0'){
				number= number*10 + (x-'0');
			}
			else if (x=='+'){
				result+=sign*number;
				number=0;
				sign=1;
			}
			else if (x=='-'){
				result+= sign*number;
				number=0;
				sign=-1;
			}
			else if (x=='('){
				stack.push(result);
				stack.push(sign);
				sign=1;
				result=0;
			}
			else if(x==')'){
				result+=sign*number;
				number=0;
				result*=stack.pop();
				result+=stack.pop();
			}
		}
		if(number != 0) result += sign * number;
		 return result;
    }
	public static void main(String args[]){
		BasicCalculator bc= new BasicCalculator();
		System.out.println(bc.calculate("10 + ( 1 + 4 ) - 1 + 132"));
	}
}