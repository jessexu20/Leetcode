import java.util.*;
public class SumClosetZero{
	public int[] findNumber(int [] nums){
		Arrays.sort(nums);
		int [] result = new int [2];
		int start = 0;
		int end = nums.length-1;
		long min = Integer.MAX_VALUE;
		while(start < end){
			int temp = Math.abs(nums[end] + nums[start]);
			if(temp < min){
				min = temp;
				result[0] = nums[start];
				result[1] = nums[end];
			}
			if(min==0) return result;
			if(nums[end] + nums[start] < 0 )
				start++;
			else end--;
		}
		return result;
	}
	public static void main(String args[]){
		SumClosetZero scz = new SumClosetZero();
		int [] nums = {-1,-4,2,3,1};
		int [] t = scz.findNumber(nums);
		System.out.println(t[0]+"\t"+t[1]);
	}
	
}