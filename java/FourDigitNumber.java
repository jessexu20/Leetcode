import java.util.*;
public class FourDigitNumber{
	public List<Integer> findNumber(){
		List<Integer> result = new ArrayList<>();
		int [] x_digit = {0,1,2,3,4,5,6,7,8,9};
		int [] y_digit = {1,2,3,4,5,6,7,8,9};
		for(int i = 1; i < x_digit.length; i++){
			for(int j = 0; j < y_digit.length; j++){
				int num1 = x_digit[i] * 10 + y_digit[j];
				int num2 = x_digit[9-i] * 10 + y_digit[8-j];
				result.add(100*num1+num2);
			}
			result.add(100 * x_digit[i] * 10 + x_digit[10-i] * 10);
		}
		System.out.println(result.size());
		List<Integer> result2 = new ArrayList<>();
		for(int i = 1000; i < 10000; i++){
			int num1 = i / 100;
			int num2 = i % 100;
			if(num1+ num2 ==100) result2.add(i);
		}
		System.out.println(result2.size());
		return result;
	}
	public static void main(String args[]){
		FourDigitNumber four = new FourDigitNumber();
		System.out.println(four.findNumber());
	}
}