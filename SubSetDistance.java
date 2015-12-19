import java.util.*;
public class SubSetDistance{
	public int maxDistance(int [] nums,int k){
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		int [][] dp = new int [k][nums.length];
		for(int i = 0; i < k; i++){
			Arrays.fill(dp[i],Integer.MAX_VALUE);//init first row with INT_INF, since one number subset distance is infinity
		}
		for(int sep = 1; sep<k; sep++){
			for(int i = 0; i < sep; i++){
				dp[sep][i] = 1;//init first one..not enough item... make it to be one.
			}
			for(int i = sep; i < nums.length; i++){
				int temp = 0;//temp is the current level max distance. dp[sep-1][j] means #(sep-1) with [0...j] subset. nums[i]-nums[j] is the sep distance
				for(int j = 0; j < i; j++){
					temp = Math.max(temp,Math.min(dp[sep-1][j],nums[i]-nums[j]));//the current level =  min of each two and the max of the all the combination.
				}
				dp[sep][i] = temp;
			}
		}
		int min = dp[k-1][nums.length-1];//the max shortest distance
		if(k>0) list.add(nums[0]);
		while(k>1){
			int index = bsBig(nums,list.get(list.size()-1)+min);//binary search for the current number.
			list.add(nums[index]);
			k--;
		}
		System.out.println(list);
		return min;
	}
	private int bsBig(int [] nums, int target){//binary search for the next bigger number.
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
		int [] nums = {1,2,6,4,9,10,12};
		System.out.println(ssd.maxDistance(nums,5));
	}
}