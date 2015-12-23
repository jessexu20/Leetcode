import java.util.*;
public class CountSmallerNumbers {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();//location result
		List<Integer> sorted = new ArrayList<>();//sorted the number, use insertion sort
		for(int i = nums.length-1; i >=0; i--){//go from the end the number 
			int index = bSbig(sorted,nums[i]);//
			sorted.add(index,nums[i]);
			result.add(index);
		}
		Collections.reverse(result);
		return result;
    }
	private int bSbig(List<Integer> arr, int target){
		if(arr.size()==0) return 0;
		int start = 0, end = arr.size()-1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(target <= arr.get(mid)) end = mid - 1;//notice that bs should find the first place to insert and there are duplicate number in the input, even if target == mid, it should go to the first half.
			else start = mid + 1;
		}
		return start;
	}
	public static void main(String args[]){
		int [] nums = {5,2,6,1};
		CountSmallerNumbers csn = new CountSmallerNumbers();
		System.out.println(csn.countSmaller(nums));
	}
}