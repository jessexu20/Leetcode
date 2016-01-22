import java.util.*;
public class MaxSubArraySum{
	public int maxSubArrayLen(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0, start = 0, sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			if(sum == k){
				max = i+1;
				start = 0;
			}
			else if(map.containsKey(sum - k)){
				if(i - map.get(sum-k) > max){
					max = i - map.get(sum-k);
					start = map.get(sum-k);
				}
			}
			if(!map.containsKey(sum))
				map.put(sum,i);
		}
		for(int i = start; i < start + max; i++)
			System.out.print(nums[i]+"\t");
		System.out.println();
		return max;
	}
	public static void main(String args[]){
		MaxSubArraySum msas = new MaxSubArraySum();
		int [] nums = {1,3,-1,1,1,1,1,2};
		System.out.println(msas.maxSubArrayLen(nums,3));
	}
}