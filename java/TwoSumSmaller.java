import java.util.*;
public class TwoSumSmaller{
	public int[] buy(int [] nums, int money){
		int start = 0, end = nums.length-1;
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int [] result = new int [2];
		while(start < end){
			int sum = nums[start] + nums[end];
			if(sum <= money){
				if( money - sum < min){
					result[0] = nums[start];
					result[1] = nums[end];
					min = money - sum;
				}
				start++;
			}
			else end--;
		}
		return result;
	}
	public static void main(String args[]){
		TwoSumSmaller bti = new TwoSumSmaller();
		int [] nums = {3,6,8,7,9};
		int [] result = bti.buy(nums,10);
		System.out.println(result[0] + "\t" + result[1]);
	}
}