import java.util.*;
public class Subset{
	Set<String> visited = new HashSet();
	public List<List<Integer>> generateSet(int [] nums){
		List<List<Integer>> result = new ArrayList();
		helper(result,new ArrayList<Integer>(),0,nums);
		return result;
	}
	public void helper(List<List<Integer>> result, List<Integer> list, int index, int [] nums){
		if(index == nums.length){
			result.add(list);
			return;
		}
		for(int i = index; i < nums.length; i++){
			List<Integer> temp = new ArrayList(list);
			temp.add(nums[i]);
			if(!visited.add(temp.toString())) continue;
			helper(result,temp,i+1,nums);
			helper(result,list,i+1,nums);
		}
	}
	public static void main(String args[]){
		Subset subset = new Subset();
		int [] nums = {1,2,3,4};
		System.out.println(subset.generateSet(nums));
	}
}