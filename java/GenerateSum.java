import java.util.*;
public class GenerateSum {
    public Set<Integer> generate(int [] nums) {
		Set<Integer> set= new HashSet<Integer>();
		helper(set,nums,0,0);
		set.remove(0);
		return set;
    }
	public void helper(Set<Integer> result,int [] nums, int index,int sum){
		result.add(sum);
		for(int i =index;i<nums.length;i++){
			helper(result,nums,i+1,sum+nums[i]);
		}
	}
	public static void main(String args[]){
		GenerateSum gs= new GenerateSum();
		int [] nums = {3,7,9};
		System.out.println(gs.generate(nums));
	}
}
