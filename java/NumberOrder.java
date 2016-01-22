import java.util.*;
public class NumberOrder {
    public String generate(String str) {
		int nums[] =new int [str.length()+1];
		for(int i =0 ; i< nums.length;i++) nums[i]=i+1;
		int count =0;
		for(int i = 0;i<str.length();i++){
			count+=(str.charAt(i)=='i')?0:1;
		}
		String result = "";
		int increase= count+2;
		int decrease= count+1;
		if(str.startsWith("i")) result+=1;//the first item..
		else result+=(decrease--);
		for(int i =0 ;i<str.length();i++){
			if(str.charAt(i)=='i') result+=String.valueOf(increase++);
			else result+=String.valueOf(decrease--);
		}
		return result;
    }
	public void swap(int []nums, int i,int j ){
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	public static void main(String args[]){
		NumberOrder no= new NumberOrder();
		
		System.out.println(no.generate("diddiiii"));
	}
}