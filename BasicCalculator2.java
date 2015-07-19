import java.util.*;
public class BasicCalculator2 {
    public int calculate(String s) {
        Stack <String> res= new Stack();
		int length=s.length();
		if (length<=0)
			return 0;
		int number= 0;
		int result= 0;
		int sign =1;
		Queue <String> que= new LinkedList();
		for (int i=0;i<length;i++){
			char x=s.charAt(i);
			if (x<='9' && x>='0'){
				number= number*10 + (x-'0');
			}
			else if (x!=' '){
				que.add(Integer.toString(number));
				number=0;
				que.add(String.valueOf(x));
			}
		}
		que.add(Integer.toString(number));
		while(!que.isEmpty()){
			String str=que.poll();
			if(str.equals("*")){
				int number1=Integer.parseInt(res.pop());
				int number2=Integer.parseInt(que.poll());
				res.push(Integer.toString(number1*number2));
			}
			else if(str.equals("/")){
				int number1=Integer.parseInt(res.pop());
				int number2=Integer.parseInt(que.poll());
				res.push(Integer.toString(number1/number2));
			}
			else{
				res.push(str);
			}
		}
		number=0;
		while(!res.isEmpty()){
			String str=res.pop();
			if (str.equals("-")){
				result=result-number;
			}
			else if (str.equals("+")){
				result=result+number;
			}
			else{
				number=Integer.parseInt(str);
			}
		}
		result+=number;
		return result;
    }
	public static void main(String args[]){
		BasicCalculator2 bc= new BasicCalculator2();
		System.out.println(bc.calculate("-1-1"));
	}
}