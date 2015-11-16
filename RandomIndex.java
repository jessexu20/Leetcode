import java.util.*;
public class RandomIndex{
	int [] agg;
	RandomIndex(int [] nums){
		agg = new int[nums.length];
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			count += nums[i];
			agg[i] = count;
		}
	}
	public int generateIndex(){
		Random r = new Random();
		int rn = r.nextInt(agg[agg.length-1]);
		return search(agg,rn)+1;
	}
	public int search(int [] nums, int target){
		int start = 0, end = nums.length-1;
		while(start <= end ){
			int mid = start + (end-start)/2;
			if(nums[mid]==target) return mid;
			if(nums[mid]>target){
				end = mid - 1;
			}
			else start = mid + 1;
		}
		return end;
	}
	public static void main(String args[]){
		int [] nums = {1,3,4,5};//1,4,8,13
		RandomIndex ri = new RandomIndex(nums);
		for(int i = 0; i < 13; i++){
			System.out.println(ri.generateIndex());
		}
	}
}