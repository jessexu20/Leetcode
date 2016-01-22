import java.util.*;
public class SubSetMaxDistance{
	public Set<Integer> findSet(int [] nums,int n){
		Arrays.sort(nums);
		int start = 1, end = nums[nums.length-1]-nums[0];
		while(start <= end){
			int dist = start + (end - start)/2;
			if(check(nums,dist,n))
				start = dist + 1;
			else end = dist - 1;
		}
		System.out.println(end);
		Set<Integer> set = new HashSet();
		set.add(nums[0]);
		int prev = nums[0];
		while(set.size()<n){
			int num = nums[bsBig(nums,prev+end)];
			set.add(num);
			prev = num;
		}
		return set;
	}
	private boolean check(int [] nums, int d, int n){
		int temp = 1;
		int prev = nums[0];
		int cur = 1;
		while(temp < n && cur < nums.length){
			if(prev + d < nums[cur]){
				prev = nums[cur++];
				temp ++;
			}
			else cur++;
			// System.out.println(prev);
		}
		return temp == n;
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
		SubSetMaxDistance sd = new SubSetMaxDistance();
		int [] nums = {1,2,5,9,12,18};
		System.out.println(sd.findSet(nums,3));
	}
}