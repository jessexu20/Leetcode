import java.util.*;
public class SubSetDistance{
	public int maxDistance(int [] nums,int k){
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		int [][] dp = new int [k][nums.length];
		for(int i = 0; i < k; i++){
			Arrays.fill(dp[i],Integer.MAX_VALUE);
		}
		for(int sep = 1; sep<k; sep++){
			dp[sep][0] = 1;
			for(int i = 1; i < nums.length; i++){
				int temp = 0;
				for(int j = 0; j < i; j++){
					temp =Math.max(temp,Math.min(dp[sep-1][j],nums[i]-nums[j]));
				}
				dp[sep][i] = Math.min(temp,dp[sep-1][i-1]);
			}
		}
		int min = dp[k-1][nums.length-1];
		if(k>0) list.add(nums[0]);
		while(k>1){
			int index = bsBig(nums,list.get(list.size()-1)+min);
			list.add(nums[index]);
			k--;
		}
		System.out.println(list);
		return min;
	}
	private int bsBig(int [] nums, int target){
		int start = 0; int end = nums.length-1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if( nums[mid] == target) return mid;
			else if(target < nums[mid]) end = mid-1;
			else start = mid+1;
		}
		return start;
	}
	public static void main(String args[]){
		SubSetDistance ssd = new SubSetDistance();
		int [] nums = {1,2,6,7,9,10,12};
		System.out.println(ssd.maxDistance(nums,4));
	}
}