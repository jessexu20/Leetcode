/*
Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
-3 -2 -1 -4 1
-4 -3 -2 -1 1
*/
import java.util.*;
class Interval{
	int index;
	int num;
	Interval(int i, int n){
		index = i;
		num = n;
	}
}
public class SubArrayCloset{
	public int [] findRange(int [] nums){
		Interval [] partSum = new Interval [nums.length];
		for(int i = 0; i < nums.length; i++){
			if(i == 0) partSum[i] = new Interval(i,nums[i]);
			else partSum[i] = new Interval(i,partSum[i-1].num + nums[i]);
		}
		Arrays.sort(partSum, new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2){
				return o1.num - o2.num;
			}
		});
		int min = Integer.MAX_VALUE;
		int [] result = new int [2];
		for(int i = 0; i < partSum.length-1; i++){
			if(Math.abs(partSum[i].num - partSum[i+1].num) < min){
				min = Math.abs(partSum[i].num - partSum[i+1].num);
				result[0] = partSum[i].index;
				result[1] = partSum[i+1].index;
				Arrays.sort(result);
				result[0]++;
			}
		}
		
		return result;
	}
	public static void main(String args[]){
		SubArrayCloset sac = new SubArrayCloset();
		int [] result = new int [2];
		int [] nums = {-3, 1, 1, -3, 5};
		result = sac.findRange(nums);
		System.out.println(result[0]+"\t"+result[1]);
	}
}